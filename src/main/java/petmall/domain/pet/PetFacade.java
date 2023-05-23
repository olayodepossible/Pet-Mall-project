package petmall.domain.pet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import petmall.adapters.mysql.pet.PetEntity;
import petmall.api.pet.dto.CreatePetRequest;


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

    // Methods for Controller from Repository
    public Pet getPet(long id) {
        return petRepository.findById(id).map(PetEntity::asPet).orElseThrow();
    }

    public List<Pet> getPets() {
        return petRepository.findAll().stream().map(PetEntity::asPet).collect(Collectors.toList());
    }

    @Transactional
    public Pet addPet(CreatePetRequest pet) {
        return petRepository.save(pet.asPet()).asPet();
    }

    @Transactional
    public Pet putPet(long id, CreatePetRequest pet) {
        return petRepository.save(pet.asPet(id)).asPet();
    }

    @Transactional
    public void deletePet(long id) {
        petRepository.deleteById(id);
    }
}
