package petmall.adapters.mysql.accessories;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Aquarium - one of accessory item
 */
@Entity
@DiscriminatorValue("aquarium")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Aquarium extends AccessoryEntity {
    private String dimensions;
    private int volume;

    public Aquarium (Long id, String name, String petType, byte[] image, String description, BigDecimal price, String dimensions, int volume) {
        super(id, name, petType, image, description, price);
        this.dimensions = dimensions;
        this.volume = volume;
    }
}
