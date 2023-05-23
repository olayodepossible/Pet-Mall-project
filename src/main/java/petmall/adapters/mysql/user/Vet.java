package petmall.adapters.mysql.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import petmall.adapters.mysql.Store;
import petmall.adapters.mysql.pet.PetEntity;
import petmall.domain.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("vet")
@NoArgsConstructor
@AllArgsConstructor
public class Vet extends UserEntity{

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Role> roles;

    @OneToMany(mappedBy = "vet")
    private List<PetEntity> petList;

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
