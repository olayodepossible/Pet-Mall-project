package petmall.adapters.mysql;

import lombok.*;
import petmall.adapters.mysql.accessories.AccessoryEntity;
import petmall.adapters.mysql.user.UserEntity;

import javax.persistence.*;
import java.util.List;

@Entity
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
    @ManyToOne
    private UserEntity owner;
    @OneToMany (mappedBy = "store")
    private List<AccessoryEntity> accessoryList;
}
