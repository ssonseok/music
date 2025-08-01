package son.suck.music.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import son.suck.music.domain.User;
import son.suck.music.dto.MusicDTO;
import son.suck.music.dto.UserDTO;
import son.suck.music.service.GameService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/music")
public class GameController {
    private final GameService gameService;
    private final ModelMapper modelMapper;
    @PostMapping("/mode")
    public void modeReq(){

    }
    @GetMapping("/solo")
    public void soloReq(){

    }
    @GetMapping("/soloplay")
    public String soloplayReq(
            Model model,
            Integer roomId,
            String genre,
            String difficulty,
            Integer fromYear,
            Integer toYear,
            HttpSession session) {

        User user = (User) session.getAttribute("loginUser");
        UserDTO loginUser = modelMapper.map(user, UserDTO.class);
        if (loginUser == null) {
            return "redirect:/music/login";
        }

        if (roomId == null) {
            model.addAttribute("errorMsg", "roomId가 없습니다.");
            return "music/errorPage";
        }

        // 필요하면 genre 등 파라미터 값 검증 가능

        MusicDTO music = gameService.getMusic(roomId, loginUser.getUno());
        if (music == null) {
            model.addAttribute("errorMsg", "음악 데이터를 찾을 수 없습니다.");
            return "music/errorPage";
        }

        model.addAttribute("music", music);
        model.addAttribute("nickname", loginUser.getNickname());
        model.addAttribute("roomId", roomId);
        model.addAttribute("userId", loginUser.getUno());

        // 파라미터들도 뷰에 전달
        model.addAttribute("genre", genre);
        model.addAttribute("difficulty", difficulty);
        model.addAttribute("fromYear", fromYear);
        model.addAttribute("toYear", toYear);

        return "music/soloplay";
    }
    }