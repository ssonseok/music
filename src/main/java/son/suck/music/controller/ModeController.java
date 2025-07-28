package son.suck.music.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/music")
public class ModeController {
    @PostMapping("/mode")
    public void modeReq(){

    }
    @GetMapping("/solo")
    public void soloReq(){

    }

//    @GetMapping("/multi")
//    public void multiReq(){
//
//    }
}
