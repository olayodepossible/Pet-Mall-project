package petmall.api.pet.dto;

import lombok.Value;
import lombok.experimental.NonFinal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Value
public class CreatePetRequest {
    @NotEmpty
    String name;
    String gender;
    String description;
    String imageUrl;
    @NotNull
    @NonFinal
    BigDecimal price;
    String petType;
    String breed;
}
