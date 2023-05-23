package petmall.api.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Value;
import petmall.adapters.mysql.user.UserEntity;

import javax.validation.constraints.NotEmpty;

@Value
public class UserRequestPayload {
    @NotEmpty
    String username;
    String firstName;
    String lastName;
    @NotEmpty
    String email;

    @JsonIgnore
    @NotEmpty
    String password;

    public UserEntity asUser() {
        return new UserEntity(null, username, firstName, lastName, email, password, null);
    }

//    public UserEntity asUser(long id) {
//        return new UserEntity(id, username, firstName, lastName, email, password, null);
//    }
}
