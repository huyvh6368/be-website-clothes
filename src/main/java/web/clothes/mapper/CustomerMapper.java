package web.clothes.mapper;

import web.clothes.dto.request.CustomerRequest;
import web.clothes.dto.response.AccountResponse;
import web.clothes.dto.response.CartResponse;
import web.clothes.dto.response.CustomerResponse;
import web.clothes.entity.Account;
import web.clothes.entity.Cart;
import web.clothes.entity.Customer;

public class CustomerMapper {
    public static Customer addRequestToEntity(CustomerRequest request, Account account, Cart cart) {
        return Customer.builder()
                .account(account)
                .cart(cart)
                .name(request.getName())
                .birthday(request.getBirthday())
                .gender(request.getGender())
                .orderCancellationCount(request.getOrderCancellationCount())
                .build();
    }

    public static Customer
    updateRequestToEntity(CustomerRequest request, Account account, Long id) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(request.getName());
        customer.setBirthday(request.getBirthday());
        customer.setGender(request.getGender());
        customer.setOrderCancellationCount(request.getOrderCancellationCount());
        customer.setAccount(account);
        return customer;
    }

    public static CustomerResponse
    entityToResponse(Customer entity, AccountResponse accountResponse, CartResponse cartResponse) {
        return CustomerResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .birthday(entity.getBirthday())
                .gender(entity.getGender())
                .orderCancellationCount(entity.getOrderCancellationCount())
                .cartResponse(cartResponse)
                .account(accountResponse)
                .build();
    }
}
