package web.clothes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import web.clothes.dto.request.AccountRequest;
import web.clothes.entity.Account;
import web.clothes.mapper.AccountMapper;
import web.clothes.repository.AccountRepository;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public String register(AccountRequest registerRequest) {
        String password = passwordEncoder.encode(registerRequest.getPassword());
        Account account = AccountMapper.addRequestToEntity(registerRequest, password);
        accountRepository.save(account);
        return "User registered successfully!";
    }
}
