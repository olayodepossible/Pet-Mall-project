package petmall.adapters.mysql.pet;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/*
 * Dog - one of Pet object
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("dog")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dog extends PetEntity {
    private DogBreed dogBreed;

}

