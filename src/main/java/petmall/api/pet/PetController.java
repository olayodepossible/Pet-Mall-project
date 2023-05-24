package petmall.api.pet;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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
@RequestMapping("/api/v1/pets")
@RequiredArgsConstructor
public class PetController {
    private final PetFacade petFacade;

    @GetMapping("/pet_id")
    public Pet getSinglePet(@RequestParam long id) {
        return petFacade.getPet(id);
    }

    @GetMapping("/")
    public List<Pet> getAllPets() {
        return petFacade.getPets();
    }

    @PostMapping("/owner_id")
    @ResponseStatus(HttpStatus.CREATED)
    public Pet addPet(@RequestParam long id, @Valid @RequestBody CreatePetRequest pet) {
        return petFacade.addPet(pet, id);
    }

//    @PutMapping("/pet_id")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Pet updatePet(@RequestParam("id") long id, @Valid @RequestBody CreatePetRequest pet) {
//        return petFacade.putPet(id, pet);
//    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePet(@PathVariable long id) {
        petFacade.deletePet(id);
    }
}
