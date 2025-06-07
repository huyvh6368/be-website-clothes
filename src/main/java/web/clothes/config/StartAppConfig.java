package web.clothes.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import web.clothes.entity.Account;
import web.clothes.repository.AccountRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class StartAppConfig {
    private final AccountRepository accountRepository;

    @Bean
    ApplicationRunner initApplicationRunner() {
        return args -> {
            boolean existsAdmin = accountRepository.existsByRole("ADMIN");

            if (!existsAdmin) {
                Account admin = new Account();
                admin.setName("admin");
                admin.setEmail("huyvh6368@gmail.com");
                admin.setPassword(new BCryptPasswordEncoder().encode("admin123")); // mã hóa password
                admin.setRole("ADMIN");
                accountRepository.save(admin);
                System.out.println("Đã tạo tài khoản admin mặc định.");
            } else {
                System.out.println("Tài khoản admin đã tồn tại.");
            }
        };
    }
}
