package petmall.domain.pet;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Value;
import lombok.experimental.NonFinal;
import petmall.adapters.mysql.user.UserEntity;

import javax.persistence.Column;
import java.math.BigDecimal;

@Value
public class Pet {
    Long id;
    String name;
    String gender;
    String description;
   String image;
    @NonFinal
    BigDecimal price;
    @NonFinal
    @JsonIgnore
    UserEntity owner;
    @NonFinal
    @JsonIgnore
    UserEntity vet;
}
