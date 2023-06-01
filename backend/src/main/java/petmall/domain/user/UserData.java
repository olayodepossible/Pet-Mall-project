package petmall.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Value;
import petmall.adapters.mysql.pet.PetEntity;
import petmall.domain.Role;

import java.util.Set;

@Value
public class UserData {
    Long id;
    String username;
    String firstName;
    String lastName;
    String email;
    @JsonIgnore
    Set<Role> roles;
    Set<PetEntity> pets;
}
