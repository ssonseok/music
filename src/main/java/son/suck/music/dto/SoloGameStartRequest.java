package son.suck.music.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SoloGameStartRequest {
    //private UserDTO userDTO;
    private String genre;
    private String difficulty;
    private int fromYear;
    private int toYear;
}
