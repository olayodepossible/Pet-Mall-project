package petmall.api.store.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class ServiceReceipt {

    String ownerFirstName;
    String ownerLastName;
    String ownerEmail;
    String ownerAddress;
    String serviceName;
    String serviceType;
    String petGender;
    int petAge;
    String description;
    BigDecimal price;
    String breed;
    String vetName;
    String vetAddress;
//    String vetSpeciality;
//    String storeName;
//    String storeAddress;
}
