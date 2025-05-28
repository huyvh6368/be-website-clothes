package web.clothes.dto.request;

import java.util.Date;
import lombok.Getter;

@Getter
public class CustomerRequest {
    private String name;
    private Long accountId;
    private Date birthday;
    private String gender;
    private Integer orderCancellationCount;
}
