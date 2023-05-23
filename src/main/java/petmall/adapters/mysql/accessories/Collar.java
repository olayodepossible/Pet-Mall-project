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
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("collar")
public class Collar extends AccessoryEntity {
    private String color;
    private BigDecimal size;
}
