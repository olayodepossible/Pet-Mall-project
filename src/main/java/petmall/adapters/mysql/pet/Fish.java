package petmall.adapters.mysql.pet;

import lombok.*;
import petmall.adapters.mysql.user.UserEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;


@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("fish")
@EqualsAndHashCode(callSuper = true)
public class Fish extends PetEntity {
    private FishBreed fishBreed;

    public Fish(Long id, String name, boolean gender, String description,
               byte[] image, BigDecimal price, UserEntity owner, UserEntity vet, FishBreed fishBreed) {
        super(id, name, gender, description, image, price, owner, vet);
        this.fishBreed = fishBreed;
    }
}

