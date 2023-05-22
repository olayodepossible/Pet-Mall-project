package petmall.domain.accessory;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class Accessory {
    Long id;
    String name;
    String petType;
    byte[] image;
    String description;
    BigDecimal price;
}
