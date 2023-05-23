package petmall.adapters.mysql.user;

import lombok.*;
import petmall.adapters.mysql.pet.PetEntity;

import javax.persistence.*;
import java.util.Set;

/*
 * UserService class for login panel, registration, privileges
 */

/*
* Dodac:
* FB login, google login
* przywileje [user, cashier, admin]
*/

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type", discriminatorType = DiscriminatorType.STRING)
public class UserEntity {
    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", fetch = FetchType.EAGER)
    private Set<PetEntity> pets;

}