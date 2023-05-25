package petmall.domain.accessory;


import petmall.adapters.mysql.accessories.AccessoryEntity;
import petmall.api.accessory.dto.CreateAccessoryRequest;

public interface AccessoryProcessor {
    String getAccessoryType();
    AccessoryEntity processAccessoryTypeReq(CreateAccessoryRequest req);
}
