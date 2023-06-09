package petmall.api.store.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Value;
import petmall.adapters.mysql.Store;
import petmall.adapters.mysql.accessories.AccessoryEntity;
import petmall.adapters.mysql.pet.PetEntity;
import petmall.adapters.mysql.user.UserEntity;
import petmall.domain.pet.Pet;

import java.util.List;
import java.util.Set;


@Value
@Builder
public class StoreDto {
   Long id;
   String name;
   String address;
   String city;
   String country;
  long managerId;
  Set<PetEntity> storePets;
  Set<UserEntity> vetList;
   List<AccessoryEntity> accessoryList;

   public Store asStoreEntity(){
      return Store.builder()
              .name(name)
              .address(address)
              .city(city)
              .country(country)
              .build();
   }

}
