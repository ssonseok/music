package son.suck.music.domain;

import jakarta.persistence.*;

@Entity
public class GameUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int runo;
    @ManyToOne
    User user;

    @ManyToOne
    GameRoom gameRoom;
}
