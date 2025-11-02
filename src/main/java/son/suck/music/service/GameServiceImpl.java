package son.suck.music.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import son.suck.music.domain.GameRoom;
import son.suck.music.domain.GameUser;
import son.suck.music.domain.Music;
import son.suck.music.domain.Record;
import son.suck.music.domain.User;
import son.suck.music.dto.*;
import son.suck.music.repository.GameRoomRepository;
import son.suck.music.repository.GameUserRepository;
import son.suck.music.repository.MusicRepository;
import son.suck.music.repository.RecordRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    private final MusicRepository musicRepository;
    private final GameRoomRepository gameRoomRepository;
    private final GameUserRepository gameUserRepository;
    private final RecordRepository recordRepository;
    private final ModelMapper modelMapper;


    public GameServiceImpl(MusicRepository musicRepository, GameRoomRepository gameRoomRepository, GameUserRepository gameUserRepository, RecordRepository recordRepository, ModelMapper modelMapper) {
        this.musicRepository = musicRepository;
        this.gameRoomRepository = gameRoomRepository;
        this.gameUserRepository = gameUserRepository;
        this.recordRepository = recordRepository;
        this.modelMapper = modelMapper;
    }
    private String clean(String str) {
        if (str == null) return "";
        return str.replaceAll("[^\\p{L}\\p{N}]", "").toLowerCase();
    }

    @Override
    public SoloGameDTO soloGame(User user, String genre, String difficulty, int fromYear, int toYear) {
        GameRoom gameRoom=GameRoom.builder() //게임방 생성 및 저장
                .mode("solo")
                .genre(genre)
                .difficulty(difficulty)
                .year_from(fromYear)
                .year_to(toYear)
                .user(user)
                .build();
        gameRoom=gameRoomRepository.save(gameRoom);

        GameUser gameUser=GameUser.builder() //게임유저 등록 및 저장
                .gameRoom(gameRoom)
                .user(user)
                .build();
        gameUser=gameUserRepository.save(gameUser);
        //랜덤10노래 조회
        List<Music> musics = musicRepository.findRandom10ByGenreAndDifficultyAndYearRange(genre, difficulty, fromYear, toYear);

        //기록 초기화(정답 여부 false)
        List<Record> records=new ArrayList<>();
        for(Music music:musics){
            Record record=Record.builder()
                    .gameRoom(gameRoom)
                    .user(user).music(music).correct(false)
                    .build();
            records.add(record);
        }
        recordRepository.saveAll(records);

        GameRoomDTO gameRoomDTO=modelMapper.map(gameRoom,GameRoomDTO.class);
        GameUserDTO gameUserDTO=modelMapper.map(gameUser,GameUserDTO.class);
        List<MusicDTO> musicDTOList=musics.stream()
                .map(music -> modelMapper.map(music,MusicDTO.class))
                .toList();

        return SoloGameDTO.builder()
                .gameRoom(gameRoomDTO)
                .gameUser(gameUserDTO)
                .musicList(musicDTOList)
                .build();
    }

    @Override
    public MusicDTO getMusic(int roomId, int userId) {
        System.out.println("getMusic 호출: roomId=" + roomId + ", userId=" + userId);
        //Record record=recordRepository.findFirstByGameRoomGrnoAndUserUnoAndCorrectFalse(roomId,userId);
        Record record = recordRepository.findFirstByGameRoomGrnoAndUserUnoAndCorrectFalseNative(roomId, userId);

        System.out.println("찾은 record: " + record);
        if(record==null)
            return null;
        Music music=record.getMusic();
        MusicDTO dto=new MusicDTO();
        dto.setMno(music.getMno());
        dto.setArtist(music.getArtist());
        dto.setDifficulty(music.getDifficulty());
        dto.setGenre(music.getGenre());
        dto.setTitle(music.getTitle());
        dto.setYear(String.valueOf(music.getYear()));
        dto.setYoutube_id(music.getYoutube_id());
        return dto;
    }

    @Override
    public int getScore(int roomId, int userId) {
        return recordRepository.countByGameRoomGrnoAndUserUnoAndCorrectTrue(roomId,userId);
    }

    @Override
    public RecordDTO getResult(int roomId, int userId) {
        Record record =recordRepository.findTopByGameRoomGrnoAndUserUnoOrderByRnoDesc(roomId,userId);
        if(record==null)
            return null;
        int score=recordRepository.countByGameRoomGrnoAndUserUnoAndCorrectTrue(roomId,userId);
        RecordDTO recordDTO=modelMapper.map(record,RecordDTO.class);

        return recordDTO;
    }

    @Override
    @Transactional
    public void skip(int roomId, int userId) {
        Record record=recordRepository.findFirstByGameRoomGrnoAndUserUnoAndCorrectFalse(roomId,userId);
        if(record!=null)
            record.skip();
    }

    @Override
    public boolean checkAnswer(Integer roomId, Integer userId, String input) {
        System.out.println("=== checkAnswer 호출 ===");
        Record record = recordRepository.findFirstByGameRoomGrnoAndUserUnoAndCorrectFalse(roomId, userId);
        if (record == null) {
            System.out.println("정답 대기중인 레코드 없음");
            return false;
        }

        String answer = clean(record.getMusic().getTitle());
        String userInput = clean(input);

        System.out.println("정답(DB): [" + answer + "]");
        System.out.println("입력값  : [" + userInput + "]");

        if (answer.equals(userInput)) {
            record.markCorrect();
            recordRepository.save(record);
            return true;
        }
        return false;
    }

}
