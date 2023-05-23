package petmall.adapters.mysql.accessories;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/*
 * Ball - one of accessory item
 */
@Entity
@Data
@Builder
@DiscriminatorValue("ball")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Ball extends AccessoryEntity {
    private BigDecimal size;
}
