package petmall.adapters.mysql.user;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import petmall.adapters.mysql.pet.PetEntity;
import petmall.domain.Role;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Set;

@Entity(name = "admin")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("admin")
public class Admin extends UserEntity{
    private boolean isAdmin;

    @Builder
    public Admin(Long id, String username, String firstName, String lastName, String email,
                 String password, Set<Role> roles, Set<PetEntity> pets, boolean isAdmin) {
        super(id, username, firstName, lastName, email, password, roles, pets);
        this.isAdmin = isAdmin;
    }
}
