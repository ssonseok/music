package son.suck.music.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import son.suck.music.domain.GameRoom;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecordDTO {
    private int rno;
    private GameRoomDTO gameRoomDTO;
    private MusicDTO musicDTO;
    private UserDTO userDTO;
}
