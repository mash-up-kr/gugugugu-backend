package mashup.gugugugu.user.repository;

import mashup.gugugugu.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserId(Long userId);
    Optional<User> findByTokenId(String tokenId);
}
