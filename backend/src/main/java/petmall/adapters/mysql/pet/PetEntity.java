package petmall.adapters.mysql.pet;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;

import lombok.Builder;
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
@Builder
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
    private int age;
    private String description;
    private String imageUrl;
    private BigDecimal price;
    private String breed;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity owner;
    @JsonIgnore
    @ManyToOne
    private UserEntity vet;

    public Pet asPetWithOwner() {
        return Pet.builder().id(id).name(name).gender(gender).description(description)
                .imageUrl(imageUrl).breed(breed).price(price).ownerUsername(owner.getUsername())
                .ownerFirstName(owner.getFirstName()).ownerLastName(owner.getLastName()).ownerEmail(owner.getEmail())
                .ownerDesignation(owner.getDesignation()).ownerAddress(owner.getAddress()).ownerCity(owner.getCity()).build();
    }
}