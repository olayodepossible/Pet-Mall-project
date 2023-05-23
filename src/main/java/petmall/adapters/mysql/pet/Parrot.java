package petmall.adapters.mysql.pet;

import lombok.*;
import petmall.adapters.mysql.user.UserEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("parrot")
@EqualsAndHashCode(callSuper = true)
public class Parrot extends PetEntity {
    private ParrotBreed parrotBreed;

    public Parrot(Long id, String name, boolean gender, String description,
               byte[] image, BigDecimal price, UserEntity owner, UserEntity vet, ParrotBreed parrotBreed) {
        super(id, name, gender, description, image, price, owner, vet);
        this.parrotBreed = parrotBreed;
    }

}
