package petmall.adapters.mysql.accessories;

import lombok.*;
import org.springframework.stereotype.Component;
import petmall.adapters.mysql.Store;
import petmall.api.accessory.dto.CreateAccessoryRequest;
import petmall.domain.accessory.AccessoryProcessor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.math.BigDecimal;

/**
 * Aquarium - one of accessory item
 */
@Entity
@Component("aquarium")
@DiscriminatorValue("aquarium")
@EqualsAndHashCode(callSuper = true)
public class Aquarium extends AccessoryEntity implements AccessoryProcessor {
    private String dimensions;
    private int volume;
    @Transient
    private static final String ACCESSORY_TYPE = "aquarium";

    @Override
    public String getAccessoryType() {
        return ACCESSORY_TYPE;
    }

    @Override
    public AccessoryEntity processAccessoryTypeReq(CreateAccessoryRequest req) {
        this.dimensions = req.getDimensions();
        this.volume = req.getVolume();
        return this;
    }
}
