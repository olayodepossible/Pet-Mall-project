package petmall.adapters.mysql.pet;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("cat")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cat extends PetEntity {
    private CatBreed catBreed;
}