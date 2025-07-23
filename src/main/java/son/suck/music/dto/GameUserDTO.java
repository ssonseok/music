package son.suck.music.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameUserDTO {
    private int runo;
    private UserDTO userDTO;
    private GameRoomDTO gameRoomDTO;
}
