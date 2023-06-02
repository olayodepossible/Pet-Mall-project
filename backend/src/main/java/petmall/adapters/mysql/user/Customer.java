package petmall.adapters.mysql.user;


import lombok.*;
import org.springframework.stereotype.Component;
import petmall.api.user.dto.UserRequestPayload;
import petmall.domain.user.UserProcessor;

import javax.persistence.*;


@Entity
@Component("client")
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("customer")
public class Customer extends UserEntity implements UserProcessor {


    @Transient
    private static final String USER_TYPE = "client";

    @Override
    public String getUserType() {
        return USER_TYPE;
    }

    @Override
    public UserEntity processUserTypeReq(UserRequestPayload req) {
        this.setDesignation(Designation.CUSTOMER.name());
        this.setPrivilege("ROLE_USER");
        return this;
    }



}
