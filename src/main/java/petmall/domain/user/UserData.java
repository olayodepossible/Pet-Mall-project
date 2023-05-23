package petmall.domain.user;

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
    Set<PetEntity> pets;
}
