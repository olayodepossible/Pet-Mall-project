package petmall.api.user.dto;


import lombok.Value;
import petmall.adapters.mysql.pet.PetEntity;
import petmall.adapters.mysql.user.UserEntity;

import java.util.Set;

@Value
public class UserResponsePayload {
    Long id;
    String username;
    String firstName;
    String lastName;
    String email;
    Set<PetEntity> pets;

    public UserEntity asUser(Long id){
        return new UserEntity(id, username, firstName, lastName, email, null, pets);

    }
}
