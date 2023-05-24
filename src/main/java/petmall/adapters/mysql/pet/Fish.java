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
@Component("FishPetProcessor")
@DiscriminatorValue("fish")
@EqualsAndHashCode(callSuper = true)
public class Fish extends PetEntity implements PetProcessor {
    private FishBreed fishBreed;

    @Transient
    private static final String PET_TYPE  = "fish";

    @Override
    public String getPetType() {
        return PET_TYPE;
    }

    @Override
    public PetEntity processPetTypeReq(CreatePetRequest req) {
        this.fishBreed = FishBreed.valueOf(req.getBreed());
        return this ;
    }
}

