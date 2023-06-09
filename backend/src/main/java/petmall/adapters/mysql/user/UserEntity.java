package petmall.adapters.mysql.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import petmall.adapters.mysql.pet.PetEntity;
import petmall.domain.user.UserData;

import javax.persistence.*;
import java.util.Set;



@Entity(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type", discriminatorType = DiscriminatorType.STRING)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String city;
    private String country;
    private String privilege;
    private String designation;
    private String profileImage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", fetch = FetchType.EAGER)
    private Set<PetEntity> pets;


    public UserData asUser(){
        return new UserData(id, username, firstName, lastName, email,address, city, country, profileImage, privilege, pets);
    }

}