package petmall.adapters.mysql.accessories;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/*
 * Ball - one of accessory item
 */
@Entity
@Data
@DiscriminatorValue("ball")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Ball extends AccessoryEntity {
    private BigDecimal size;

    public Ball(Long id, String name, String petType, byte[] image, String description, BigDecimal price, BigDecimal size) {
        super(id, name, petType, image, description, price);
        this.size = size;
    }
}
