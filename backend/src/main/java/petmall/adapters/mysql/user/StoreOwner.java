package petmall.adapters.mysql.user;


import lombok.*;
import org.springframework.stereotype.Component;
import petmall.adapters.mysql.Store;
import petmall.api.user.dto.UserRequestPayload;
import petmall.domain.user.UserProcessor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Component("store_owner")
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("store_owner")
@NoArgsConstructor
public class StoreOwner extends UserEntity implements UserProcessor {
    private boolean isStoreOwner;

    @OneToMany(mappedBy = "owner")
    private Set <Store> stores;
    @Transient
    private static final String USER_TYPE = "store_owner";

    @Override
    public String getUserType() {
        return USER_TYPE;
    }

    @Override
    public UserEntity processUserTypeReq(UserRequestPayload req) {
        this.isStoreOwner = true;
        this.setPrivilege("ROLE_OWNER_ADMIN");
        return this;
    }

}
