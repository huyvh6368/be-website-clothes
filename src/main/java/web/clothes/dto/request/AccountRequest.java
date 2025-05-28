package web.clothes.dto.request;

import lombok.Getter;

@Getter
public class AccountRequest {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String role;
}