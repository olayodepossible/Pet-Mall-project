package petmall.adapters.mysql.user;

import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;
import petmall.api.user.dto.UserRequestPayload;
import petmall.domain.user.UserProcessor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@Component("admin")
@DiscriminatorValue("admin")
@EqualsAndHashCode(callSuper = true)
public class Admin extends UserEntity implements UserProcessor {
    private boolean isAdmin;
    @Transient
    private static final String USER_TYPE = "admin";

    @Override
    public String getUserType() {
        return USER_TYPE;
    }

    @Override
    public UserEntity processUserTypeReq(UserRequestPayload req) {
        this.isAdmin = true;
        this.setPrivilege("ROLE_ADMIN");
        return this;
    }
}
