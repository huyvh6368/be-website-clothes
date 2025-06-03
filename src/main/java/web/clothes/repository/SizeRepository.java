package web.clothes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.clothes.entity.Size;

@Repository
public interface SizeRepository extends JpaRepository<Size, Long> {
}
