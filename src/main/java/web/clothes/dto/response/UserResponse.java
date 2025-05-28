package web.clothes.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserResponse {
    private Long id;
    private String name;
    private AccountResponse account;
    private Integer status;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
