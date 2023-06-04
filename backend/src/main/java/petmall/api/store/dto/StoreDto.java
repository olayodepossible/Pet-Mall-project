package petmall.api.store.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Value;
import petmall.adapters.mysql.Store;
import petmall.adapters.mysql.user.UserEntity;


@Value
public class StoreDto {
   Long id;
   String name;
   String address;
   String city;
   String country;
   @JsonIgnore
   UserEntity owner;

   public Store asStoreEntity(){
      return Store.builder()
              .name(name)
              .address(address)
              .city(city)
              .country(country)
              .build();
   }
}
