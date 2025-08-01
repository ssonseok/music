package son.suck.music.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import son.suck.music.domain.User;
import son.suck.music.dto.*;
import son.suck.music.service.GameService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/music")
public class GameRestController {
    private final GameService gameService;

    @PostMapping("/start")
    public ResponseEntity<SoloGameDTO> start(@RequestBody SoloGameStartRequest request, HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        if(user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        SoloGameDTO soloGameDTO = gameService.soloGame(
                user,
                request.getGenre(),
                request.getDifficulty(),
                request.getFromYear(),
                request.getToYear()
        );
        return ResponseEntity.ok(soloGameDTO);
    }


    @GetMapping("/{roomId}/{userId}/music")
    public ResponseEntity<MusicDTO> getCurrentMusic(
            @PathVariable Integer roomId,
            @PathVariable Integer userId) {
        MusicDTO musicDTO = gameService.getMusic(roomId, userId);
        if (musicDTO == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(musicDTO);
    }

    @PostMapping("/{roomId}/{userId}/check")
    public ResponseEntity<Boolean> check(
            @PathVariable Integer roomId,
            @PathVariable Integer userId,
            @RequestBody Map<String, String> data) {

        String input = data.get("input");
        System.out.println("컨트롤러 도착: roomId=" + roomId + ", userId=" + userId + ", input=" + input);

        boolean result = gameService.checkAnswer(roomId, userId, input);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{roomId}/{userId}/score")
    public ResponseEntity<Integer> getScore(
            @PathVariable Integer roomId,
            @PathVariable Integer userId) {
        int score = gameService.getScore(roomId, userId);
        return ResponseEntity.ok(score);
    }

    @PostMapping("/{roomId}/{userId}/skip")
    public ResponseEntity<Void> skip(
            @PathVariable Integer roomId,
            @PathVariable Integer userId) {
        gameService.skip(roomId, userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{roomId}/{userId}/result")
    public ResponseEntity<RecordDTO> getResult(
            @PathVariable Integer roomId,
            @PathVariable Integer userId) {
        RecordDTO recordDTO = gameService.getResult(roomId, userId);
        if (recordDTO == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(recordDTO);
    }
    }




