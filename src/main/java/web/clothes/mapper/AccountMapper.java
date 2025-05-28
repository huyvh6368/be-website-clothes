package web.clothes.mapper;

import web.clothes.dto.request.AccountRequest;
import web.clothes.dto.response.AccountResponse;
import web.clothes.entity.Account;

public class AccountMapper {
    public static Account addRequestToEntity(AccountRequest request, String password) {
        return Account.builder()
                .email(request.getEmail())
                .password(password)
                .name(request.getName())
                .role("USER")
                .phoneNumber(request.getPhoneNumber())
                .build();
    }

    public static Account updateRequestToEntity(AccountRequest request, String password, Long id) {
        Account account = new Account();
        account.setId(id);
        account.setEmail(request.getEmail());
        account.setPassword(password);
        account.setName(request.getName());
        account.setPhoneNumber(request.getPhoneNumber());
        account.setRole("USER");
        return account;
    }

    public static AccountResponse entityToResponse(Account entity) {
        return AccountResponse.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .name(entity.getName())
                .phoneNumber(entity.getPhoneNumber())
                .role(entity.getRole())
                .build();
    }
}
