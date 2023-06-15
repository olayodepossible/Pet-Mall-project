package petmall.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import petmall.adapters.mysql.user.*;
import petmall.api.user.dto.UserRequestPayload;
import petmall.exception.DataNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserFactory userFactory;


    public UserData createUser(UserRequestPayload payload) {
        UserEntity  user = userFactory.getUserTypeEntity(payload.getUserType()).processUserTypeReq(payload);
        user.setUsername(payload.getUsername());
        user.setFirstName(payload.getFirstName());
        user.setLastName(payload.getLastName());
        user.setEmail(payload.getEmail());
        user.setPassword(payload.getPassword());
        user.setAddress(payload.getAddress());
        user.setCity(payload.getCity());
        user.setCountry(payload.getCountry());
        user.setProfileImage(payload.getProfileImage());
        return userRepository.save(user).asUser();
    }

    public List<UserData> getAllUsers() {
        return userRepository.findAll().stream().map(UserEntity::asUser).collect(Collectors.toList());
    }

    public UserEntity getUser(long id) {
         UserEntity user =  userRepository.findById(id)
                 .orElseThrow( () -> new DataNotFoundException(String.format("User with Id: %d not found", id )));
        if (user.getPrivilege().equals("ROLE_STORE_ADMIN")) {
            return UserEntity.builder().email(user.getEmail()).address(user.getAddress()).city(user.getCity())
                    .firstName(user.getFirstName()).lastName(user.getLastName()).privilege(user.getPrivilege())
                    .profileImage(user.getProfileImage()).designation(user.getDesignation()).username(user.getUsername())
                    .country(user.getCountry()).build();
        }
        return user;
    }

    public UserEntity loginUser(UserRequestPayload payload) {
        UserEntity user =  userRepository.findByUsername(payload.getUsername()).orElseThrow( () -> new DataNotFoundException("User with Id: %d not found" ));
        if (user.getPrivilege().equals("ROLE_STORE_ADMIN")) {
            return UserEntity.builder().email(user.getEmail()).address(user.getAddress()).city(user.getCity())
                    .firstName(user.getFirstName()).lastName(user.getLastName()).privilege(user.getPrivilege())
                    .profileImage(user.getProfileImage()).designation(user.getDesignation()).username(user.getUsername())
                    .country(user.getCountry()).build();
        }
        return user;
    }
}
