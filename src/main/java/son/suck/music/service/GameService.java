package son.suck.music.service;

import son.suck.music.domain.Record;
import son.suck.music.domain.User;
import son.suck.music.dto.MusicDTO;
import son.suck.music.dto.RecordDTO;
import son.suck.music.dto.SoloGameDTO;

import java.util.List;

public interface GameService {
    //-----솔로모드-----
    SoloGameDTO soloGame(User user, String genre, String difficulty, int fromYear, int toYear);//시작세팅
    MusicDTO getMusic(int roomId,int userId);//노래 요청
    int getScore(int roomId, int userId);//정답현황
    RecordDTO getResult(int roomId, int userId);//최종결과
    void skip(int roomId, int userId);//노래 스킵
    boolean checkAnswer(Integer roomId, Integer userId, String input);//정답제출(정답 true)
}
