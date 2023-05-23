package petmall.adapters.mysql.pet;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/*
 * Cat - one of Pet object
 */
@Data
@Entity
@Builder
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("cat")
@NoArgsConstructor
@AllArgsConstructor
public class Cat extends PetEntity {
    private CatBreed catBreed;
}