package petmall.domain.pet;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.NonFinal;
import petmall.adapters.mysql.user.UserEntity;

import javax.persistence.Column;
import java.math.BigDecimal;

@Value
@Builder
public class Pet {
    Long id;
    String name;
    String gender;
    int age;
    String description;
    String imageUrl;
    String breed;
    @NonFinal
    BigDecimal price;
    long ownerId;
    String ownerUsername;
    String ownerFirstName;
    String ownerLastName;
    String ownerEmail;
    String ownerDesignation;
    String ownerAddress;
    String ownerCity;
    String storeLink;

}
