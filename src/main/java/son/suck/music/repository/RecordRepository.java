package son.suck.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import son.suck.music.domain.Record;

public interface RecordRepository extends JpaRepository<Record, Integer> {
}
