package petmall.domain.pet;

import lombok.Value;
import lombok.experimental.NonFinal;
import petmall.adapters.mysql.user.UserEntity;

import javax.persistence.Column;
import java.math.BigDecimal;

@Value
public class Pet {
    Long id;
    String name;
    boolean gender;
    String description;
    byte[] image;
    @NonFinal
    BigDecimal price;
    @NonFinal
    UserEntity owner;
    @NonFinal
    UserEntity vet;
}
