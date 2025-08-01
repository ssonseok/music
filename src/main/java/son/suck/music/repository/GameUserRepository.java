package son.suck.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import son.suck.music.domain.GameUser;

import java.util.List;

public interface GameUserRepository extends JpaRepository<GameUser,Integer> {
    List<GameUser> findByGameRoomGrno(Integer grno);//특정 게임방에 속한 유저 리스트 조회
}
