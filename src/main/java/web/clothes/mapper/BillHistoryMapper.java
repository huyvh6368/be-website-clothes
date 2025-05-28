package web.clothes.mapper;

import web.clothes.dto.request.BillHistoryRequest;
import web.clothes.dto.response.BillHistoryResponse;
import web.clothes.dto.response.BillResponse;
import web.clothes.dto.response.UserResponse;
import web.clothes.entity.Bill;
import web.clothes.entity.BillHistory;
import web.clothes.entity.User;

public class BillHistoryMapper {

    public static BillHistory addRequestToEntity(BillHistoryRequest request, Bill bill, User user) {
        return BillHistory.builder()
                .bill(bill)
                .user(user)
                .userAction(request.getUserAction())
                .build();
    }


    public static BillHistory updateRequestToEntity(BillHistoryRequest request, Bill bill, User user, Long id) {
        BillHistory billHistory = new BillHistory();
        billHistory.setBill(bill);
        billHistory.setUser(user);
        billHistory.setId(id);
        billHistory.setUserAction(request.getUserAction());
        return billHistory;
    }

    public static BillHistoryResponse entityToResponse(BillHistory entity, BillResponse billResponse, UserResponse userResponse) {
        return BillHistoryResponse.builder()
                .id(entity.getId())
                .status(entity.getStatus())
                .createDate(entity.getCreateDate())
                .updateDate(entity.getUpdateDate())
                .user(userResponse)
                .userAction(entity.getUserAction())
                .date(entity.getDate())
                .build();
    }
}
