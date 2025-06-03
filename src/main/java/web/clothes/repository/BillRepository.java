package web.clothes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.clothes.entity.Bill;
@Repository
public interface BillRepository extends JpaRepository<Bill,Long> {
}
