package petmall.adapters.mysql.pet;

import lombok.*;
import org.springframework.stereotype.Component;
import petmall.api.pet.dto.CreatePetRequest;
import petmall.domain.pet.PetProcessor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@Component("ParrotPetProcessor")
@DiscriminatorValue("parrot")
@EqualsAndHashCode(callSuper = true)
public class Parrot extends PetEntity implements PetProcessor {
    @Transient
    private static final String PET_TYPE = "parrot";
    @Override
    public String getPetType() {
        return PET_TYPE;
    }
    @Override
    public PetEntity processPetTypeReq(CreatePetRequest req) {
        this.setBreed(ParrotBreed.valueOf(req.getBreed()).toString());
        return this;
    }

}
