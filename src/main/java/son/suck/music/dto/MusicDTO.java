package son.suck.music.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MusicDTO {
    private int mno;
    private String title;
    private String artist;
    private String youtube_id;
    private String genre;
    private String year;
    private String difficulty;
}
