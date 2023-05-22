package petmall.adapters.mysql.accessories;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/*
 * Muzzle - one of accessory item
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@DiscriminatorValue("collar")
public class Collar extends AccessoryEntity {
    private String color;
    private BigDecimal size;

    public Collar(long id, String name, String pet_type, byte[] image, String description, BigDecimal price, String color, BigDecimal size) {
        super(id, name, pet_type, image, description, price);
        this.color = color;
        this.size = size;
    }
}
