package petmall.adapters.mysql.user;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("admin")
public class Admin extends UserEntity{
    private boolean isAdmin;
}
