package son.suck.music.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GameRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int grno;
    private String mode;
    private String genre;
    private String difficulty;
    private int year_from;
    private int year_to;

    @ManyToOne
    User user;
}
