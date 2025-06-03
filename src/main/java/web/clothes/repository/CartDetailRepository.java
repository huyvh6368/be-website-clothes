package web.clothes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import web.clothes.entity.CartDetail;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {
    @Query("select  c from CartDetail  c where c.cart.id =:cartId and c.productDetail.id =:productId")
    Optional<CartDetail> findCartDetailByCartIdAndProductId(Long cartId, Long productId);

    @Query("select c from CartDetail c where c.cart.id = :cartId and c.status != 0")
    List<CartDetail> findCartDetailByCartId(Long cartId);
}
