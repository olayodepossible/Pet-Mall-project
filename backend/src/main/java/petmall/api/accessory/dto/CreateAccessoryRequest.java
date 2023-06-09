package petmall.api.accessory.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Value;
import lombok.experimental.NonFinal;
import petmall.adapters.mysql.Store;
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
    @NotEmpty
    String accessoryType;
    String imageUrl;
    String description;
    String dimensions;
    @NonFinal
    int volume;
    String color;
    @NonFinal
    BigDecimal size;
    String fodderType;
    @NotNull
    BigDecimal price;
    @JsonIgnore
    @NonFinal
    Store store;

    public AccessoryEntity asAccessory() {
        return new AccessoryEntity(null, name, petType, imageUrl, description, price, store);
    }

    public AccessoryEntity asAccessory (Long id) {
        return new AccessoryEntity(id, name, petType, imageUrl, description, price, store);
    }
}
