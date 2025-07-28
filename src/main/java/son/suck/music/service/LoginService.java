package son.suck.music.service;

import son.suck.music.domain.User;
import son.suck.music.dto.UserDTO;

import java.util.Optional;

public interface LoginService {
    boolean join(UserDTO userDTO);
    Optional<User> login(UserDTO userDTO);

}
