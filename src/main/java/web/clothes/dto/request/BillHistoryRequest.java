package web.clothes.dto.request;
import lombok.Getter;

@Getter
public class BillHistoryRequest {
    private Long billId;
    private Long userId;
    private String userAction;
}
