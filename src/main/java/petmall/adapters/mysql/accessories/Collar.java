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


@Entity
@Component("collar")
@DiscriminatorValue("collar")
@EqualsAndHashCode(callSuper = true)
public class Collar extends AccessoryEntity implements AccessoryProcessor {
    private String color;
    private BigDecimal size;

    @Transient
    private static final String ACCESSORY_TYPE = "collar";

    @Override
    public String getAccessoryType() {
        return ACCESSORY_TYPE;
    }

    @Override
    public AccessoryEntity processAccessoryTypeReq(CreateAccessoryRequest req) {
        this.color = req.getColor();
        this.size = req.getSize();
        return this;
    }
}
