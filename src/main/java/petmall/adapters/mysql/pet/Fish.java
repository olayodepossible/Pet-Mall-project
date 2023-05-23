package petmall.adapters.mysql.pet;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("fish")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fish extends PetEntity {
    private FishBreed fishBreed;

}

