package petmall.adapters.mysql.pet;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@Entity
@Builder
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("dog")
@NoArgsConstructor
@AllArgsConstructor
public class Dog extends PetEntity {
    private DogBreed dogBreed;

}

