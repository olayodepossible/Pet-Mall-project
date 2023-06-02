package petmall.api.accessory.dto;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class AccessoryData {
    Long id;
    String name;
    String petType;
    String imageUrl;
    String description;
    BigDecimal price;
    Long storeId;
    String storeName;
    String address;
    String city;
    String country;
}
