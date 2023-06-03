package petmall.adapters.mysql.pet;


import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;
import petmall.api.pet.dto.CreatePetRequest;
import petmall.domain.pet.PetProcessor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;


@Entity
@DiscriminatorValue("cat")
@Component("CatPetProcessor")
@EqualsAndHashCode(callSuper = true)
public class Cat extends PetEntity implements PetProcessor {
    @Transient
    private static final String PET_TYPE  = "cat";

    @Override
    public String getPetType() {
        return PET_TYPE;
    }

    @Override
    public PetEntity processPetTypeReq(CreatePetRequest req) {
        this.setBreed(CatBreed.valueOf(req.getBreed()).toString());
        return this ;
    }
}