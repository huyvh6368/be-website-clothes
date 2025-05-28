package web.clothes.dto.response;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BillHistoryResponse {
    private Long id;
    private String userAction;
    private LocalDateTime date;
    private UserResponse user;
    private Integer status;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
