package chronodb.chrono.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import chronodb.chrono.models.User;

public interface UserRepository extends JpaRepository<User,Long>{

    boolean existsByEmail(String email);
    boolean existsByUserName(String userName);
    Optional<User> findByUserName(String userName);

}
