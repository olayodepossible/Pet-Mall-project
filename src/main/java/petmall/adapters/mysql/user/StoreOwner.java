package petmall.adapters.mysql.user;


import lombok.*;
import petmall.adapters.mysql.Store;
import petmall.adapters.mysql.pet.PetEntity;
import petmall.domain.Role;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "store_owner")
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("store_owner")
@NoArgsConstructor
public class StoreOwner extends UserEntity{
    private boolean isStoreOwner;

    @OneToMany(mappedBy = "owner")
    private Set <Store> stores;

    @Builder
    public StoreOwner(Long id, String username, String firstName, String lastName, String email, String password,
                      Set<Role> roles, Set<PetEntity> pets, boolean isStoreOwner, Set<Store> stores) {
        super(id, username, firstName, lastName, email, password, roles, pets);
        this.isStoreOwner = isStoreOwner;
    }
}
