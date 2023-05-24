package petmall.adapters.mysql.pet;

import lombok.*;
import petmall.adapters.mysql.user.UserEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("dog")
@EqualsAndHashCode(callSuper = true)
public class Dog extends PetEntity {
    private DogBreed dogBreed;

    @Builder
    public Dog(Long id, String name, String gender, String description,
               byte[] image, BigDecimal price, UserEntity owner, UserEntity vet, DogBreed dogBreed) {
        super(id, name, gender, description, image, price, owner, vet);
        this.dogBreed = dogBreed;
    }

}

