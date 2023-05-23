package petmall.api.user.dto;


import lombok.Value;
import petmall.adapters.mysql.user.UserEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Value
public class UserRequestPayload {
    @NotEmpty
    String username;
    String firstName;
    String lastName;
    @NotEmpty
    String userType;
    @NotEmpty
    @Email
    String email;
    @NotEmpty
    String password;
    @NotEmpty

    public UserEntity asUser() {
        return new UserEntity(username, firstName, lastName, email, password, null);
    }

}
