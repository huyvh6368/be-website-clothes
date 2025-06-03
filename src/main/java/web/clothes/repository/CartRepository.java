package web.clothes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.clothes.entity.Cart;
import web.clothes.entity.Customer;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findCartByCustomer(Customer customer);

    Cart findCartByCustomerId(Long customerId);
}
