package petmall.adapters.mysql.pet;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/*
 * Cat - one of Pet object
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("cat")
@Data
@NoArgsConstructor
public class Cat extends PetEntity {
    private CatBreed catBreed;

    public Cat(Long id, String name, boolean gender, String description, byte[] image, BigDecimal price, CatBreed catBreed) {
        super(id, name, gender, description, image, price);
        this.catBreed = catBreed;
    }
}