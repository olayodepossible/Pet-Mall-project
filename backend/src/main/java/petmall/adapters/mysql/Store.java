package petmall.adapters.mysql;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import petmall.adapters.mysql.accessories.AccessoryEntity;
import petmall.adapters.mysql.user.UserEntity;
import petmall.api.store.dto.StoreDto;

import javax.persistence.*;
import java.util.List;

@Entity(name = "stores")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private String city;
    private String country;
    @JsonIgnore
    @ManyToOne
    private UserEntity owner;
    @OneToMany (mappedBy = "store")
    private List<AccessoryEntity> accessoryList;

    public StoreDto asStore(){
        return new StoreDto( name, address, city, country, owner);
    }
}
