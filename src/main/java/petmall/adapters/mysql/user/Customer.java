package petmall.adapters.mysql.user;


import lombok.*;

import javax.persistence.*;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("pet_owner")
public class Customer extends UserEntity{
    private String address;
    private String city;
    private String country;
}
