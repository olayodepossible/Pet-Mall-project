package petmall.adapters.mysql.accessories;


import lombok.*;
import petmall.adapters.mysql.Store;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/*
 * Muzzle - one of accessory item
 */
@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("collar")
@EqualsAndHashCode(callSuper = true)
public class Collar extends AccessoryEntity {
    private String color;
    private BigDecimal size;

    public Collar(long id, String name, String petType, byte[] image, String description,
                  BigDecimal price,Store store, String color, BigDecimal size) {
        super(id, name, petType, image, description, price, store);
        this.color = color;
        this.size = size;
    }
}
