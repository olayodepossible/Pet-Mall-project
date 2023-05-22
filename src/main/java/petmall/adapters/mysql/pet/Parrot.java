package petmall.adapters.mysql.pet;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/*
 * Parrot - one of Pet object
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("parrot")
@Data
@NoArgsConstructor
public class Parrot extends PetEntity {
    private ParrotBreed parrotBreed;

    public Parrot(Long id, String name, boolean gender, String description, byte[] image, BigDecimal price, ParrotBreed parrotBreed) {
        super(id, name, gender, description, image, price);
        this.parrotBreed = parrotBreed;
    }
}
