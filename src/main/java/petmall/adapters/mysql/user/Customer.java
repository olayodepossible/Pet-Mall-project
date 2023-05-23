package petmall.adapters.mysql.user;


import lombok.*;
import petmall.adapters.mysql.pet.PetEntity;
import petmall.domain.Role;

import javax.persistence.*;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("pet_owner")
public class Customer extends UserEntity{
    private String address;
    private String city;
    private String country;

    @Builder
    public Customer(Long id, String username, String firstName, String lastName, String email, String password,
                    Set<Role> roles, Set<PetEntity> pets, String address, String city, String country) {
        super(id, username, firstName, lastName, email, password, roles, pets);
        this.address = address;
        this.city = city;
        this.country = country;
    }
}
