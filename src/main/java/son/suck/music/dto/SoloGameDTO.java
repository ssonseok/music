package son.suck.music.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import son.suck.music.domain.GameRoom;
import son.suck.music.domain.GameUser;
import son.suck.music.domain.Music;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class SoloGameDTO {
    private GameRoomDTO gameRoom;
    private GameUserDTO gameUser;
    private List<MusicDTO> musicList;
}
