package son.suck.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import son.suck.music.domain.Music;

public interface MusicRepository extends JpaRepository<Music,Integer> {
}
