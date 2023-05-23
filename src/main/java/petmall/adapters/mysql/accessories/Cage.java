package petmall.adapters.mysql.accessories;

import lombok.*;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/*
 * Cage - one of accessory item
 */
@Entity
@Data
@Builder
@DiscriminatorValue("cage")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Cage extends AccessoryEntity {
    private String dimensions;

}
