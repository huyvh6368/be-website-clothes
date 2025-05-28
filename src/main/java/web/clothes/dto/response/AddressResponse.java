package web.clothes.dto.response;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AddressResponse {
    private Long id;
    private CustomerResponse customer;
    private String receiver;
    private String phoneNumber;
    private String province;
    private String district;
    private String ward;
    private String address;
    private Boolean addressDefault;
    private Integer status;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
