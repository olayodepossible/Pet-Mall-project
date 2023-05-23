package petmall.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import petmall.adapters.mysql.user.UserEntity;
import petmall.api.user.dto.UserRequestPayload;
import petmall.exception.UserNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public UserData createUser(UserRequestPayload payload) {
        return userRepository.save(payload.asUser()).asUser();
    }

    public List<UserData> getAllUsers() {
        return userRepository.findAll().stream().map(UserEntity::asUser).collect(Collectors.toList());
    }

    public UserData getUser(long id) {
         UserEntity user = userRepository.findById(id)
                 .orElseThrow( () -> new UserNotFoundException(String.format("User with Id: %d not found", id )));
         return user.asUser();
    }
}
