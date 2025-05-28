package web.clothes.dto.response;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CartResponse {
    private Long id;
    private CustomerResponse customer;
    private Integer status;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
//    private List<CartDetailResponse> cartDetails;
}
