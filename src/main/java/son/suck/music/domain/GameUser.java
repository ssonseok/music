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
public class GameUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int runo;
    @ManyToOne
    User user;

    @ManyToOne
    GameRoom gameRoom;
}
