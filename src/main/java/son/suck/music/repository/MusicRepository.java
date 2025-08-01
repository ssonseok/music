package son.suck.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import son.suck.music.domain.Music;
import son.suck.music.dto.MusicDTO;

import java.util.List;

public interface MusicRepository extends JpaRepository<Music,Integer> {
    @Query(value = "SELECT * FROM music " +
            "WHERE genre = :genre " +
            "AND difficulty = :difficulty " +
            "AND year BETWEEN :fromYear AND :toYear " +
            "ORDER BY RAND() LIMIT 10", nativeQuery = true)
    List<Music> findRandom10ByGenreAndDifficultyAndYearRange(
            String genre, String difficulty, int fromYear, int toYear);
}
