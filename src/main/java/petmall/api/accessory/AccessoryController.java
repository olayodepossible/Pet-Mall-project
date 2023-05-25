package petmall.api.accessory;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import petmall.adapters.mysql.accessories.AccessoryEntity;
import petmall.api.accessory.dto.AccessoryData;
import petmall.api.accessory.dto.CreateAccessoryRequest;
import petmall.domain.accessory.Accessory;
import petmall.domain.accessory.AccessoryFacade;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("api/v1/accessories")
@RequiredArgsConstructor
public class AccessoryController {
    private final AccessoryFacade accessoryFacade;

    @GetMapping("/{id}")
    public Collection<AccessoryData> getAccessoryByStore(@PathVariable long id) {
        return accessoryFacade.accessoryByStore(id);
    }

    @GetMapping("/")
    public List<AccessoryData> getAllAccessories() {
        return accessoryFacade.getAccessories();
    }

    @PostMapping("/store")
    @ResponseStatus(HttpStatus.CREATED)
    public AccessoryData addAccessory(@RequestParam long id, @Valid @RequestBody CreateAccessoryRequest accessory) {
        return accessoryFacade.addAccessory(id, accessory);
    }

    @PutMapping("/{id}")
    public Accessory updateAccessory(@PathVariable long id, @Valid @RequestBody CreateAccessoryRequest accessory) {
        return accessoryFacade.putAccessory(id, accessory);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccessory(@PathVariable long id) {
        accessoryFacade.deleteAccessory(id);
    }
}
