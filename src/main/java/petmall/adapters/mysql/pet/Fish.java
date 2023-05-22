package petmall.adapters.mysql.pet;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/*
 * Fish - one of Pet object
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("fish")
@NoArgsConstructor
@Data
public class Fish extends PetEntity {
    private FishBreed fishBreed;

    public Fish(Long id, String name, boolean gender, String description, byte[] image, BigDecimal price, FishBreed fishBreed) {
        super(id, name, gender, description, image, price);
        this.fishBreed = fishBreed;
    }
}

