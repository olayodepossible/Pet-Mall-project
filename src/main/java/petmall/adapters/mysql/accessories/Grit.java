package petmall.adapters.mysql.accessories;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/*
 * Grit - one of accessory item
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("grit")
public class Grit extends AccessoryEntity {
    public Grit(long id, String name, String pet_type, byte[] image, String description, BigDecimal price) {
        super(id, name, pet_type, image, description, price);
    }
}
