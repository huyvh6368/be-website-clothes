package web.clothes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.clothes.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
