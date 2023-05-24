package petmall.adapters.mysql.user;


import lombok.*;
import org.springframework.stereotype.Component;
import petmall.adapters.mysql.pet.PetEntity;
import petmall.api.user.dto.UserRequestPayload;
import petmall.domain.Role;
import petmall.domain.user.UserProcessor;

import javax.persistence.*;
import java.util.Set;


@Entity
@Component("client")
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("pet_owner")
public class Customer extends UserEntity implements UserProcessor {
    private String address;
    private String city;
    private String country;

    @Transient
    private static final String USER_TYPE = "client";

    @Override
    public String getUserType() {
        return USER_TYPE;
    }

    @Override
    public UserEntity processUserTypeReq(UserRequestPayload req) {
        this.address = req.getAddress();
        this.city = req.getCity();
        this.country = req.getCity();
        this.addRole("ROLE_USER");
        return this;
    }



}
