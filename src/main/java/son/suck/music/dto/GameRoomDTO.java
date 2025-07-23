package son.suck.music.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameRoomDTO {
    private int grno;
    private String mode;
    private String genre;
    private String difficulty;
    private int year_from;
    private int year_to;
    private UserDTO userDTO;
}
