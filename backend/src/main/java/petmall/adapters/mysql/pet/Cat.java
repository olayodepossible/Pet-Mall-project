package petmall.adapters.mysql.pet;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import petmall.adapters.mysql.user.UserEntity;
import petmall.api.pet.dto.CreatePetRequest;
import petmall.domain.pet.Pet;
import petmall.domain.pet.PetProcessor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.math.BigDecimal;


@Entity
@DiscriminatorValue("cat")
@Component("CatPetProcessor")
@EqualsAndHashCode(callSuper = true)
public class Cat extends PetEntity implements PetProcessor {
    private CatBreed catBreed;
    @Transient
    private static final String PET_TYPE  = "cat";

    @Override
    public String getPetType() {
        return PET_TYPE;
    }

    @Override
    public PetEntity processPetTypeReq(CreatePetRequest req) {
        this.catBreed = CatBreed.valueOf(req.getBreed());
        return this ;
    }
}