package petmall.adapters.mysql.pet;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("parrot")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Parrot extends PetEntity {
    private ParrotBreed parrotBreed;

}
