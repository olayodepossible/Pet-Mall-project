package petmall.adapters.mysql.accessories;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Aquarium - one of accessory item
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("aquarium")
@EqualsAndHashCode(callSuper = true)
public class Aquarium extends AccessoryEntity {
    private String dimensions;
    private int volume;
}
