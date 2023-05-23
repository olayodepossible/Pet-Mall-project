package petmall.adapters.mysql.accessories;


import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("leash")
public class Leash extends AccessoryEntity {
    private BigDecimal length;
    private String color;
    private String material;
}
