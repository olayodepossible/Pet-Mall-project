package petmall.adapters.mysql.accessories;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import petmall.adapters.mysql.Store;
import petmall.domain.accessory.Accessory;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "accessories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "accessory_type", discriminatorType = DiscriminatorType.STRING)
public class AccessoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String petType;
    private byte[] image;
    private String description;
    private BigDecimal price;
    @JsonIgnore
    @ManyToOne
    private Store store;

    public Accessory asAccessory() {
        return new Accessory( id, name, petType, image, description, price, store);
    }
}
