package petmall.adapters.mysql.pet;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import petmall.adapters.mysql.user.UserEntity;
import petmall.domain.pet.Pet;

import javax.persistence.*;
import java.math.BigDecimal;

/*
 * SuperClass for pet object
 */

@Data
@Entity(name = "pets")
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="pet_type", discriminatorType = DiscriminatorType.STRING) // creating new column with @DiscriminatorValue in entities which extending pet
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String gender;
    private String description;
    private byte[] image;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity owner;
    @ManyToOne
    private UserEntity vet;


    public Pet asPet() {
        return new Pet( id, name, gender, description, image, price, owner, vet);
    }
}