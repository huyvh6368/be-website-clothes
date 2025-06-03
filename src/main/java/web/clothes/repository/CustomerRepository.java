package web.clothes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.clothes.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
