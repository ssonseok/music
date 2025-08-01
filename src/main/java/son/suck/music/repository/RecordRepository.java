package son.suck.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import son.suck.music.domain.Record;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Integer> {
    Record findFirstByGameRoomGrnoAndUserUnoAndCorrectFalse(int grno, int uno);
    int countByGameRoomGrnoAndUserUnoAndCorrectTrue(int grno, int uno);
    Record findTopByGameRoomGrnoAndUserUnoOrderByRnoDesc(int grno, int uno);
    @Query(value = "SELECT * FROM record WHERE game_room_grno = :grno AND user_uno = :uno AND correct = 0 LIMIT 1", nativeQuery = true)
    Record findFirstByGameRoomGrnoAndUserUnoAndCorrectFalseNative(@Param("grno") int grno, @Param("uno") int uno);

}
