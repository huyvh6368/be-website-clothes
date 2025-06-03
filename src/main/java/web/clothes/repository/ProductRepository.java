package web.clothes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.clothes.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
