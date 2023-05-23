package petmall.domain.accessory;

import lombok.Value;
import lombok.experimental.NonFinal;
import petmall.adapters.mysql.Store;

import java.math.BigDecimal;

@Value
public class Accessory {
    Long id;
    String name;
    String petType;
    byte[] image;
    String description;
    @NonFinal
    BigDecimal price;
    @NonFinal
    Store store;
}
