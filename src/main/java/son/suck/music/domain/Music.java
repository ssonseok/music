package son.suck.music.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mno;
    private String title;
    private String artist;
    private String youtube_id;
    private String genre;
    private String year;
    private String difficulty;

}
