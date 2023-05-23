package petmall.adapters.mysql.pet;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import petmall.adapters.mysql.user.UserEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;


@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("cat")
@Data
@NoArgsConstructor
public class Cat extends PetEntity {
    private CatBreed catBreed;

    public Cat(Long id, String name, boolean gender, String description,
               byte[] image, BigDecimal price, UserEntity owner, UserEntity vet, CatBreed catBreed) {
        super(id, name, gender, description, image, price, owner, vet);
        this.catBreed = catBreed;
    }
}