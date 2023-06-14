package petmall.api.user.dto;


import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Value
public class UserRequestPayload {
    @NotEmpty
    String username;
    @NotEmpty
    String firstName;
    @NotEmpty
    String lastName;
    @NotEmpty
    String userType;
    @NotEmpty
    @Email
    String email;
    @NotEmpty
    String password;
    String specialty;
    String address;
    String city;
    String country;
    String profileImage;



}
