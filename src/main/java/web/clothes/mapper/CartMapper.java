package web.clothes.mapper;

import web.clothes.dto.response.CartResponse;
import web.clothes.dto.response.CustomerResponse;
import web.clothes.entity.Cart;
import web.clothes.entity.Customer;

public class CartMapper {
    public static Cart addRequestToEntity(Customer customer) {
        return Cart.builder().customer(customer).build();
    }

    public static Cart updateRequestToEntity(Customer customer, Long id) {
        Cart cart = new Cart();
        cart.setId(id);
        cart.setCustomer(customer);
        return cart;
    }

    public static CartResponse entityToResponse(Cart entity, CustomerResponse customerResponse) {
        return CartResponse.builder()
                .id(entity.getId())
                .customer(customerResponse)
                .build();
    }
}
