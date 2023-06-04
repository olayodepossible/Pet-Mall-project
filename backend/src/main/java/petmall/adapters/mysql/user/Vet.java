package petmall.adapters.mysql.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.stereotype.Component;
import petmall.adapters.mysql.Store;
import petmall.adapters.mysql.pet.PetEntity;
import petmall.api.user.dto.UserRequestPayload;
import petmall.domain.user.UserProcessor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Component("vet")
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("vet")
public class Vet extends UserEntity implements UserProcessor {

    private String speciality;
    @OneToMany(mappedBy = "vet")
    private Set<PetEntity> petList;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH}, mappedBy = "vetList")
    @JsonIgnore
    private Set<Store> storeList;
    @Transient
    private static final String USER_TYPE = "vet";

    @Override
    public String getUserType() {
        return USER_TYPE;
    }

    @Override
    public UserEntity processUserTypeReq(UserRequestPayload req) {
        this.setDesignation(Designation.VET.name());
        this.speciality = req.getSpecialty();
        this.setPrivilege("ROLE_VET_ADMIN");
        return this;
    }
}
