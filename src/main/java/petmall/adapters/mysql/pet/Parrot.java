package petmall.adapters.mysql.pet;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/*
 * Parrot - one of Pet object
 */
@Data
@Entity
@Builder
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("parrot")
@NoArgsConstructor
@AllArgsConstructor
public class Parrot extends PetEntity {
    private ParrotBreed parrotBreed;

}
