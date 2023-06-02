package petmall.domain.accessory;

import lombok.Data;
import lombok.Value;
import lombok.experimental.NonFinal;
import petmall.adapters.mysql.Store;

import java.math.BigDecimal;

@Value
@Data
public class Accessory {
    Long id;
    String name;
    String petType;
    String imageUrl;
    String description;
    @NonFinal
    BigDecimal price;
}
