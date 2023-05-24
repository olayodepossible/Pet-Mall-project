package petmall.adapters.mysql.pet;

import lombok.*;
import org.springframework.stereotype.Component;
import petmall.adapters.mysql.user.UserEntity;
import petmall.api.pet.dto.CreatePetRequest;
import petmall.domain.pet.PetProcessor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.math.BigDecimal;

@Entity
@Component("DogPetProcessor")
@DiscriminatorValue("dog")
@EqualsAndHashCode(callSuper = true)
public class Dog extends PetEntity implements PetProcessor {
    private DogBreed dogBreed;
    @Transient
    private static final String PET_TYPE  = "dog";

    @Override
    public String getPetType() {
        return PET_TYPE;
    }

    @Override
    public PetEntity processPetTypeReq(CreatePetRequest req) {
        this.dogBreed = DogBreed.valueOf(req.getBreed());
        return this ;
    }

}

