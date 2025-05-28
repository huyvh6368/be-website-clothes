package web.clothes.dto.response;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AccountResponse {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String role;
    private Integer status;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
