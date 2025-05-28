package web.clothes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import web.clothes.dto.request.AccountRequest;
import web.clothes.dto.request.LoginRequest;
import web.clothes.dto.request.RefreshTokenRequest;
import web.clothes.dto.response.JwtResponse;
import web.clothes.entity.Account;
import web.clothes.mapper.AccountMapper;
import web.clothes.repository.AccountRepository;
import web.clothes.security.UserDetailImpl;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    // handler register
    public void register(AccountRequest request) {
        String password = passwordEncoder.encode(request.getPassword());
        Account account = AccountMapper.addRequestToEntity(request, password);
        accountRepository.save(account);
        UserDetailImpl userDetails = new UserDetailImpl(account);
        var refreshToken = jwtService.generateRefreshToken(userDetails);
        account.setRefreshToken(refreshToken);
        accountRepository.save(account);
    }

    // handler login
    public JwtResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var account = accountRepository.findByEmail(request.getEmail())
                .orElseThrow();
        UserDetailImpl userDetail = new UserDetailImpl(account);
        var accessToken = jwtService.generateAccessToken(userDetail);
        var refreshToken = jwtService.generateRefreshToken(userDetail);
        account.setRefreshToken(refreshToken);
        accountRepository.save(account);
        return JwtResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public JwtResponse refreshToken(RefreshTokenRequest request) {
        String refreshToken = request.getRefreshToken();

        // Validate refresh token
        if (!jwtService.isTokenValid(refreshToken)) {
            throw new RuntimeException("Refresh token is invalid");
        }

        // Lấy thông tin user từ refresh token
        String userEmail = jwtService.extractUsername(refreshToken);
        Account account = accountRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Kiểm tra refresh token có khớp với database
        if (!refreshToken.equals(account.getRefreshToken())) {
            throw new RuntimeException("Refresh token does not match");
        }
        UserDetailImpl userDetails = new UserDetailImpl(account);
        // Tạo token mới
        String newAccessToken = jwtService.generateAccessToken(userDetails);
        String newRefreshToken = jwtService.generateRefreshToken(userDetails);

        // Cập nhật refresh token mới vào database
        account.setRefreshToken(newRefreshToken);
        accountRepository.save(account);

        return JwtResponse.builder()
                .accessToken(newAccessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
