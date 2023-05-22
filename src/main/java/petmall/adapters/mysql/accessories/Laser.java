package petmall.adapters.mysql.accessories;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/*
 * Laser - one of accessory item
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("7")
public class Laser extends AccessoryEntity {
    private String color;

    public Laser(long id, String name, String pet_type, byte[] image, String description, BigDecimal price, String color) {
        super(id, name, pet_type, image, description, price);
        this.color = color;
    }
}
