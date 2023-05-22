package petmall.api.accessory;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import petmall.api.accessory.dto.CreateAccessoryRequest;
import petmall.domain.accessory.Accessory;
import petmall.domain.accessory.AccessoryFacade;

import javax.validation.Valid;
import java.util.List;

/*
 * Controller for Accessories
 * Initialized methods for CRUD
 */
@RestController
@RequiredArgsConstructor
public class AccessoryController {
    private final AccessoryFacade accessoryFacade;

    @GetMapping("/accessories/{id}")
    public Accessory getSingleAccessory(@PathVariable long id) {
        return accessoryFacade.getAccessory(id);
    }

    @GetMapping("/accessories")
    public List<Accessory> getAllAccessories() {
        return accessoryFacade.getAccessories();
    }

    @PostMapping("/accessories")
    @ResponseStatus(HttpStatus.CREATED)
    public Accessory addAccessory(@Valid @RequestBody CreateAccessoryRequest accessory) {
        return accessoryFacade.addAccessory(accessory);
    }

    @PutMapping("/accessories/{id}")
    public Accessory putAccessory(@PathVariable long id,@Valid @RequestBody CreateAccessoryRequest accessory) {
        return accessoryFacade.putAccessory(id, accessory);
    }

    @DeleteMapping("/accessories/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccessory(@PathVariable long id) {
        accessoryFacade.deleteAccessory(id);
    }
}
