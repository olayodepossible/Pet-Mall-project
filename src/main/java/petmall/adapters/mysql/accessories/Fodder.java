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
@Component("fodder")
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("fodder")
public class Fodder extends AccessoryEntity implements AccessoryProcessor {
    private String fodderType;    // dry[F] or wet[T]


    @Transient
    private static final String ACCESSORY_TYPE = "fodder";

    @Override
    public String getAccessoryType() {
        return ACCESSORY_TYPE;
    }

    @Override
    public AccessoryEntity processAccessoryTypeReq(CreateAccessoryRequest req) {
        this.fodderType = req.getFodderType();
        return this;
    }
}
