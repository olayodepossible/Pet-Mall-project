package petmall.adapters.mysql.accessories;

import lombok.*;
import petmall.adapters.mysql.Store;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/*
 * Cage - one of accessory item
 */
@Entity
@Data
@DiscriminatorValue("cage")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Cage extends AccessoryEntity {
    private String dimensions;

    public Cage(long id, String name, String petType, byte[] image, String description, BigDecimal price, Store store, String dimensions) {
        super(id, name, petType, image, description, price, store);
        this.dimensions = dimensions;
    }

}
