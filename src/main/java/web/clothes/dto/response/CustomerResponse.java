package web.clothes.dto.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CustomerResponse {
    private Long id;
    private String name;
    private AccountResponse account;
    private Date birthday;
    private String gender;
    private Integer orderCancellationCount;
    private AccountResponse accountResponse;
    private CartResponse cartResponse;
    private Integer status;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
