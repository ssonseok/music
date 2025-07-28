package son.suck.music.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import son.suck.music.service.LoginService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/music")
public class MusicController {
    private final LoginService loginService;

    @GetMapping("/main")
    public void main(){

    }

}
