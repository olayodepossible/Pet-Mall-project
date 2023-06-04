package petmall.domain.pet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import petmall.adapters.mysql.pet.PetEntity;
import petmall.adapters.mysql.user.UserEntity;
import petmall.api.pet.dto.CreatePetRequest;
import petmall.domain.user.UserRepository;
import petmall.exception.DataNotFoundException;


import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Service class for Pet object
 * Initialized methods for Pet object with CRUD in PetController
 */
@Service
@RequiredArgsConstructor
public class PetFacade {

    private final PetRepository petRepository;
    private final UserRepository userRepository;
    private final PetFactory petFactory;
    public Pet getPet(long id) {
        return petRepository.findById(id).map(PetEntity::asPetWithOwner).orElseThrow();
    }

    public Collection<Pet> getStorePets() {
        return petRepository.findPetOwnByStore().stream().map(PetEntity::asPetWithOwner).collect(Collectors.toList());
    }

    @Transactional
    public Pet addPet(CreatePetRequest req, long id) {
        UserEntity user = userRepository.findById(id).orElseThrow( () -> new DataNotFoundException("Pet Owner not found"));
        PetEntity petEntity = petFactory.getPetType(req.getPetType()).processPetTypeReq(req);
        petEntity.setName(req.getName());
        petEntity.setImageUrl(req.getImageUrl());
        petEntity.setGender(req.getGender());
        petEntity.setOwner(user);
        petEntity.setPrice(req.getPrice());
        petEntity.setVet(null);
        petEntity.setAge(req.getAge());
        petEntity.setDescription(req.getDescription());
        return petRepository.save(petEntity).asPetWithOwner();

    }

    @Transactional
    public Pet updatePet(long id, CreatePetRequest pet) {
        return petRepository.save(pet.asPetUpdate(id)).asPetWithOwner();
    }

    public Pet updatePetWithVet(UserEntity vet, Long petId) {
        PetEntity pet = petRepository.findById(petId).orElseThrow(() -> new DataNotFoundException("Pet Data not found"));
        pet.setVet(vet);
        return petRepository.save(pet).asPetWithOwner();
    }

    public List<PetEntity> getCustomerPet (long id){
        return petRepository.getPetsByOwnerId(id);
    }

    @Transactional
    public void deletePet(long id) {
        petRepository.deleteById(id);
    }


}
