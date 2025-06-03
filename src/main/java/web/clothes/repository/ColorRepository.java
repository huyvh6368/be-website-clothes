package web.clothes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.clothes.entity.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {
}
