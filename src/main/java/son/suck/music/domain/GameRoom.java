package son.suck.music.domain;

import jakarta.persistence.*;

@Entity
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
