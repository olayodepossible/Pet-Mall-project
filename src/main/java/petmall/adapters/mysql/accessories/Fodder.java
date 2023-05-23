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
@DiscriminatorValue("fodder")
public class Fodder extends AccessoryEntity {
    private boolean fodderType;    // dry[F] or wet[T]

}
