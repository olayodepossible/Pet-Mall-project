package petmall.adapters.mysql.accessories;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/*
 * Lead - one of accessory item
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("leash")
public class Leash extends AccessoryEntity {
    private BigDecimal length;
    private String color;
    private String material;

    public Leash(long id, String name, String pet_type, byte[] image, String description, BigDecimal price, BigDecimal length, String color, String material) {
        super(id, name, pet_type, image, description, price);
        this.length = length;
        this.color = color;
        this.material = material;
    }
}
