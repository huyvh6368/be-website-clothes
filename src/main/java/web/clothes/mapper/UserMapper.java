package web.clothes.mapper;

import web.clothes.dto.request.UserRequest;
import web.clothes.dto.response.AccountResponse;
import web.clothes.dto.response.UserResponse;
import web.clothes.entity.Account;
import web.clothes.entity.User;

public class UserMapper {
    public static User addRequestToEntity(UserRequest request, Account account) {
        return User.builder()
                .account(account)
                .name(request.getName())
                .build();
    }

    public static User updateRequestToEntity(UserRequest request, Account account, Long id) {
        User user = new User();
        user.setId(id);
        user.setName(request.getName());
        user.setAccount(account);
        return user;
    }

    public static UserResponse entityToResponse(User entity, AccountResponse accountResponse) {
        return UserResponse.builder()
                .id(accountResponse.getId())
                .name(accountResponse.getName())
                .account(accountResponse)
                .build();
    }
}
