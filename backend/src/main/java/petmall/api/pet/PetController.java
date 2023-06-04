package petmall.api.pet;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import petmall.api.pet.dto.CreatePetRequest;
import petmall.domain.pet.Pet;
import petmall.domain.pet.PetFacade;

import javax.validation.Valid;
import java.util.Collection;
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

    @GetMapping("/{id}")
    public Pet getSinglePet(@RequestParam long id) {
        return petFacade.getPet(id);
    }

    @GetMapping( "/store")
    public Collection<Pet> getAllStorePets() {
        return petFacade.getStorePets();
    }

    @PostMapping("/owner/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Pet addPet(@RequestParam long id, @Valid @RequestBody CreatePetRequest pet) {
        return petFacade.addPet(pet, id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Pet editPet(@RequestParam long id, @Valid @RequestBody CreatePetRequest pet) {
        return petFacade.updatePet(id, pet);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePet(@PathVariable long id) {
        petFacade.deletePet(id);
    }
}
