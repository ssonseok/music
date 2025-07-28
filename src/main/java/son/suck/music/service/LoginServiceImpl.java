package son.suck.music.service;

import org.springframework.stereotype.Service;
import son.suck.music.domain.User;
import son.suck.music.dto.UserDTO;
import son.suck.music.repository.UserRepository;

import java.util.Optional;
@Service
public class LoginServiceImpl implements LoginService{

    private final UserRepository userRepository;

    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean join(UserDTO userDTO) {
        if(userRepository.existsById(userDTO.getId()))
            return false;

        User user=User.builder()
                .id(userDTO.getId())
                .pw(userDTO.getPw())
                .nickname(userDTO.getNickname())
                .build();
        userRepository.save(user);
        return true;
    }

    @Override
    public Optional<User> login(UserDTO userDTO) {
        return userRepository.findById(userDTO.getId())
                .filter(user -> user.getPw().equals(userDTO.getPw()));
    }
}
