package son.suck.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import son.suck.music.domain.GameUser;

public interface GameUserRepository extends JpaRepository<GameUser,Integer> {
}
