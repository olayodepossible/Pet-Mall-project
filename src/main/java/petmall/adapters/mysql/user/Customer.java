package petmall.adapters.mysql.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import petmall.domain.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("pet_owner")
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends UserEntity{

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Role> roles;

    @JsonIgnore
    public void addRole(String roleName) {
        if(this.roles == null) {
            this.roles = new HashSet<>();
        }
        Role role = new Role();
        role.setName(roleName);
        this.roles.add(role);
    }
}
