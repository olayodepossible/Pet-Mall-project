package petmall.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Value;
import petmall.adapters.mysql.pet.PetEntity;

import java.util.Set;

@Value
public class UserData {
    Long id;
    String username;
    String firstName;
    String lastName;
    String email;
    String address;
    String city;
    String country;
    String profileImage;
    @JsonIgnore
    String privilege;
    @JsonIgnore
    Set<PetEntity> pets;
}
