package petmall.api.pet.dto;

import lombok.Value;
import lombok.experimental.NonFinal;
import petmall.adapters.mysql.pet.PetEntity;
import petmall.adapters.mysql.user.UserEntity;

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
    @NonFinal
    BigDecimal price;
    @NonFinal
    UserEntity owner;
    @NonFinal
    UserEntity vet;

    public PetEntity asPet() {
        return new PetEntity(null, name, gender, description, image, price, owner, vet);
    }

    public PetEntity asPet(Long id) {
        return new PetEntity(id, name, gender, description, image, price, owner, vet);
    }
}
