package petmall.adapters.mysql.accessories;

import lombok.*;
import petmall.adapters.mysql.Store;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Aquarium - one of accessory item
 */
@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("aquarium")
@EqualsAndHashCode(callSuper = true)
public class Aquarium extends AccessoryEntity {
    private String dimensions;
    private int volume;

    public Aquarium (Long id, String name, String petType, byte[] image, String description, BigDecimal price, Store store, String dimensions, int volume) {
        super(id, name, petType, image, description, price, store);
        this.dimensions = dimensions;
        this.volume = volume;
    }

}
