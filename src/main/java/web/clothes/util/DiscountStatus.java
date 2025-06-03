package web.clothes.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DiscountStatus {
    public static final Integer SAP_DIEN_RA = 1;
    public static final Integer DANG_DIEN_RA = 2;
    public static final Integer DA_DIEN_RA = 0;
}
