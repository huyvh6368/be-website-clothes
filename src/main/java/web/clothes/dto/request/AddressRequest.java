package web.clothes.dto.request;

import lombok.Getter;

@Getter
public class AddressRequest {
    private Long customerId;
    private String receiver;
    private String phoneNumber;
    private String province;
    private String district;
    private String ward;
    private String address;
    private Boolean addressDefault;
}
