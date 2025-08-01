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
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rno;
    private Boolean correct;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_uno")
    User user;

    @ManyToOne
    @JoinColumn(name = "game_room_grno")
    GameRoom gameRoom;

    @ManyToOne
    @JoinColumn(name = "music_mno")
    Music music;

    public void skip(){
        this.correct=false;
    }
    public void markCorrect(){
        this.correct=true;
    }

}
