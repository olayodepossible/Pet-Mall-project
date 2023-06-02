package petmall.domain.pet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import petmall.adapters.mysql.pet.PetEntity;
import petmall.adapters.mysql.user.UserEntity;
import petmall.api.pet.dto.CreatePetRequest;
import petmall.domain.user.UserRepository;
import petmall.exception.UserNotFoundException;


import javax.transaction.Transactional;
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

    // Methods for Controller from Repository
    public Pet getPet(long id) {
        return petRepository.findById(id).map(PetEntity::asPet).orElseThrow();
    }

    public List<Pet> getPets() {
        return petRepository.findAll().stream().map(PetEntity::asPet).collect(Collectors.toList());
    }

    @Transactional
    public Pet addPet(CreatePetRequest req, long id) {
        UserEntity user = userRepository.findById(id).orElseThrow( () -> new UserNotFoundException("Pet Owner not found"));
        PetEntity petEntity = petFactory.getPetType(req.getPetType()).processPetTypeReq(req);
        petEntity.setName(req.getName());
        petEntity.setImageUrl(req.getImageUrl());
        petEntity.setGender(req.getGender());
        petEntity.setOwner(user);
        petEntity.setPrice(req.getPrice());
        petEntity.setVet(null);
        petEntity.setDescription(req.getDescription());
        return petRepository.save(petEntity).asPet();

    }

//    @Transactional
//    public Pet putPet(long id, CreatePetRequest pet) {
//        return petRepository.save(pet.asPet(id)).asPet();
//    }

    @Transactional
    public void deletePet(long id) {
        petRepository.deleteById(id);
    }
}
