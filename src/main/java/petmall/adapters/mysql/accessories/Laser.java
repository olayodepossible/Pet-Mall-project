package petmall.adapters.mysql.accessories;


import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("7")
public class Laser extends AccessoryEntity {
    private String color;
}
