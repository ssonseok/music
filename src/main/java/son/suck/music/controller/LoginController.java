package son.suck.music.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import son.suck.music.domain.User;
import son.suck.music.dto.UserDTO;
import son.suck.music.service.LoginService;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/music")
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/join")
    public void joinReq(){

    }
    @PostMapping("/join")
    public String join(UserDTO userDTO, Model model){
        if(loginService.join(userDTO))
            return "redirect:/music/login";
        else{
            model.addAttribute("error","id중복!");
            return "music/join";
        }
    }
    @GetMapping("/login")
    public void loginReq(){

    }
    @PostMapping("/login")
    public String login(UserDTO userDTO, Model model, HttpSession httpSession){
        Optional<User> result=loginService.login(userDTO);
        if(result.isPresent()) {
            httpSession.setAttribute("loginNickname",result.get().getNickname());
            return "redirect:/music/main";
        }
        else{
            model.addAttribute("error","로그인 실패!");
            return "/music/login";
        }
    }
    @PostMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/music/main";
    }

}
