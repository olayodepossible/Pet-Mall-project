package petmall.adapters.mysql.accessories;


import lombok.*;
import petmall.adapters.mysql.Store;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("fodder")
public class Fodder extends AccessoryEntity {
    private boolean fodderType;    // dry[F] or wet[T]

    public Fodder(long id, String name, String petType, byte[] image, String description,
                  BigDecimal price, Store store, boolean fodderType) {
        super(id, name, petType, image, description, price, store);
        this.fodderType = fodderType;
    }
}
