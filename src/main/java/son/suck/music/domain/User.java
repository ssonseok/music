package son.suck.music.domain;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uno;
    @Column(nullable = false, unique = true)
    private String id;
    @Column(nullable = false)
    private String pw;
    @Column(nullable = false, unique = true)
    private String nickname;
}
