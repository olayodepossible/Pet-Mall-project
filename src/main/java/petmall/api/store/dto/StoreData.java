package petmall.api.store.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Value;
import petmall.adapters.mysql.Store;
import petmall.adapters.mysql.accessories.AccessoryEntity;
import petmall.adapters.mysql.user.UserEntity;

import java.util.List;


@Value
public class StoreData {
   Long id;
   String name;
   String address;
   String city;
   String country;
   List<AccessoryEntity> accessoryList;

}
