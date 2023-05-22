package petmall.api.pet.dto;

import lombok.Value;
import petmall.adapters.mysql.pet.PetEntity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Value
public class CreatePetRequest {
    @NotEmpty
    String name;
    boolean gender;
    String description;
    byte[] image;
    @NotNull
    BigDecimal price;

    public PetEntity asPet() {
        return new PetEntity(
                null,
                name,
                gender,
                description,
                image,
                price
        );
    }

    public PetEntity asPet(Long id) {
        return new PetEntity(
                id,
                name,
                gender,
                description,
                image,
                price
        );
    }
}
