package petmall.adapters.mysql.user;


import lombok.*;
import org.springframework.stereotype.Component;
import petmall.adapters.mysql.pet.PetEntity;
import petmall.api.user.dto.UserRequestPayload;
import petmall.domain.user.UserProcessor;

import javax.persistence.*;
import java.util.List;


@Entity
@Component("vet")
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("vet")
public class Vet extends UserEntity implements UserProcessor {

    private String speciality;
    @OneToMany(mappedBy = "vet")
    private List<PetEntity> petList;
    @Transient
    private static final String USER_TYPE = "vet";

    @Override
    public String getUserType() {
        return USER_TYPE;
    }

    @Override
    public UserEntity processUserTypeReq(UserRequestPayload req) {
        this.speciality = req.getSpecialty();
        this.setPrivilege("ROLE_VET_ADMIN");
        return this;
    }
}
