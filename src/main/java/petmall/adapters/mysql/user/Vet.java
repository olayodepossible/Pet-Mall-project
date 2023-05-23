package petmall.adapters.mysql.user;


import lombok.*;
import petmall.adapters.mysql.pet.PetEntity;
import petmall.domain.Role;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("vet")
@NoArgsConstructor
public class Vet extends UserEntity{

    private String speciality;
    @OneToMany(mappedBy = "vet")
    private List<PetEntity> petList;

    @Builder
    public Vet(Long id, String username, String firstName, String lastName,
               String email, String password, Set<Role> roles, Set<PetEntity> pets, String speciality) {
        super(id, username, firstName, lastName, email, password, roles, pets);
        this.speciality = speciality;
    }
}
