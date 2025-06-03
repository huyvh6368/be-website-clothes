package web.clothes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.clothes.dto.request.CartRequest;
import web.clothes.dto.response.CartResponse;
import web.clothes.entity.Cart;
import web.clothes.entity.Customer;
import web.clothes.mapper.CartMapper;
import web.clothes.repository.CartRepository;
import web.clothes.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;

    public CartResponse createCart(CartRequest cartRequest) {
        Customer customer = customerRepository.findById(cartRequest.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Cart cart = CartMapper.addRequestToEntity(customer);
        cartRepository.save(cart);
        return CartMapper.entityToResponse(cart);
    }

    public CartResponse findCartByIdCustomer(Long customerId) {
        Cart cart = cartRepository.findCartByCustomerId(customerId);
        if (cart == null) {
            throw new RuntimeException("Cart not found");
        }
        return CartMapper.entityToResponse(cart);
    }

}
