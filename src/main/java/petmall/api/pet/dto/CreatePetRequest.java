package petmall.api.pet.dto;

import lombok.Value;
import lombok.experimental.NonFinal;
import petmall.adapters.mysql.pet.CatBreed;
import petmall.adapters.mysql.pet.DogBreed;
import petmall.adapters.mysql.pet.FishBreed;
import petmall.adapters.mysql.pet.ParrotBreed;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Value
public class CreatePetRequest {
    @NotEmpty
    String name;
    String gender;
    String description;
    byte[] image;
    @NotNull
    @NonFinal
    BigDecimal price;
    String petType;
    String breed;
}
