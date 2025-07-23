package son.suck.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import son.suck.music.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
