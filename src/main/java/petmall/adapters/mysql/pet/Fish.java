package petmall.adapters.mysql.pet;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/*
 * Fish - one of Pet object
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("fish")
@EqualsAndHashCode(callSuper = true)
public class Fish extends PetEntity {
    private FishBreed fishBreed;
}

