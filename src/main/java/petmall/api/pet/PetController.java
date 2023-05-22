package petmall.api.pet;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import petmall.api.pet.dto.CreatePetRequest;
import petmall.domain.pet.Pet;
import petmall.domain.pet.PetFacade;

import javax.validation.Valid;
import java.util.List;

/*
 * Controller for Pets
 * Initialized methods for CRUD
 */
@RestController
@RequiredArgsConstructor
public class PetController {
    private final PetFacade petFacade;

    @GetMapping("/pets/{id}")
    public Pet getSinglePet(@PathVariable long id) {
        return petFacade.getPet(id);
    }

    @GetMapping("/pets")
    public List<Pet> getAllPets() {
        return petFacade.getPets();
    }

    @PostMapping("/pets")
    @ResponseStatus(HttpStatus.CREATED)
    public Pet addPet(@Valid @RequestBody CreatePetRequest pet) {
        return petFacade.addPet(pet);
    }

    @PutMapping("/pets/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Pet putPet(@PathVariable("id") long id, @Valid @RequestBody CreatePetRequest pet) {
        return petFacade.putPet(id, pet);
    }

    @DeleteMapping("/pets/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePet(@PathVariable long id) {
        petFacade.deletePet(id);
    }
}
