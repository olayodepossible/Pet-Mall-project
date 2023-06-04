package petmall.api.pet.dto;

import lombok.Value;
import lombok.experimental.NonFinal;
import petmall.adapters.mysql.pet.PetEntity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Value
public class CreatePetRequest {
    @NotEmpty
    String name;
    String gender;
    int age;
    String description;
    String imageUrl;
    @NotNull
    @NonFinal
    BigDecimal price;
    String petType;
    String breed;

    public PetEntity asPetUpdate (Long id){
        return PetEntity.builder()
                .name(name)
                .gender(gender)
                .age(age)
                .description(description)
                .imageUrl(imageUrl)
                .price(price)
                .breed(breed)
                .build();
    }
}
