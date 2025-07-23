package son.suck.music.domain;

import jakarta.persistence.*;

@Entity
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rno;

    @ManyToOne
    User user;

    @ManyToOne
    GameRoom gameRoom;

    @ManyToOne
    Music music;
}
