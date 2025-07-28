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
