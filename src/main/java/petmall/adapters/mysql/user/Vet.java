package petmall.adapters.mysql.user;


import lombok.*;
import petmall.adapters.mysql.pet.PetEntity;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("vet")
@NoArgsConstructor
@AllArgsConstructor
public class Vet extends UserEntity{

    private String speciality;
    @OneToMany(mappedBy = "vet")
    private List<PetEntity> petList;

}
