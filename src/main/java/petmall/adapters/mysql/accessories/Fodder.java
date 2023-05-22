package petmall.adapters.mysql.accessories;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/*
 * Foder - one of accessory item
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("fodder")
public class Fodder extends AccessoryEntity {
    private boolean fodder_type;    // dry[F] or wet[T]

    public Fodder(long id, String name, String pet_type, byte[] image, String description, BigDecimal price, boolean fodder_type) {
        super(id, name, pet_type, image, description, price);
        this.fodder_type = fodder_type;
    }
}
