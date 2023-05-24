package petmall.domain.pet;

import petmall.adapters.mysql.pet.PetEntity;
import petmall.api.pet.dto.CreatePetRequest;

public interface PetProcessor {
    String getPetType();
    PetEntity processPetTypeReq(CreatePetRequest req);
}
