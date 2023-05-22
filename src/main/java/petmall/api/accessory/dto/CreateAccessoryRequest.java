package petmall.api.accessory.dto;

import lombok.Value;
import petmall.adapters.mysql.accessories.AccessoryEntity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Value
public class CreateAccessoryRequest {
    @NotEmpty
    String name;
    @NotEmpty
    String petType;
    byte[] image;
    String description;
    @NotNull
    BigDecimal price;

    public AccessoryEntity asAccessory() {
        return new AccessoryEntity(
                null,
                name,
                petType,
                image,
                description,
                price
        );
    }

    public AccessoryEntity asAccessory (Long id) {
        return new AccessoryEntity(
                id,
                name,
                petType,
                image,
                description,
                price
        );
    }
}
