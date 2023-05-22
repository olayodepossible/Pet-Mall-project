package petmall.adapters.mysql.pet;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/*
 * Dog - one of Pet object
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("dog")
@Data
@NoArgsConstructor
public class Dog extends PetEntity {
    private DogBreed dogBreed;

    public Dog(Long id, String name, boolean gender, String description, byte[] image, BigDecimal price, DogBreed dogBreed) {
        super(id, name, gender, description, image, price);
        this.dogBreed = dogBreed;
    }
}

