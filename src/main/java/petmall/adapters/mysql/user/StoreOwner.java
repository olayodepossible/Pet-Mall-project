package petmall.adapters.mysql.user;


import lombok.*;
import petmall.adapters.mysql.Store;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("store_owner")
@NoArgsConstructor
@AllArgsConstructor
public class StoreOwner extends UserEntity{
    private boolean isStoreOwner;

    @OneToMany(mappedBy = "owner")
    private Set <Store> stores;

}
