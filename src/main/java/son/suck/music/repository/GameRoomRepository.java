package son.suck.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import son.suck.music.domain.GameRoom;


public interface GameRoomRepository extends JpaRepository<GameRoom,Integer> {
}
