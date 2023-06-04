package petmall.adapters.mysql;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import petmall.adapters.mysql.accessories.AccessoryEntity;
import petmall.adapters.mysql.user.UserEntity;
import petmall.adapters.mysql.user.Vet;
import petmall.api.store.dto.StoreDto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.LAZY,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE, CascadeType.DETACH,
        })
    @JoinTable(name = "store_vets",
            joinColumns = { @JoinColumn(name = "store_id") },
            inverseJoinColumns = { @JoinColumn(name = "vet_id") })
    private Set<UserEntity> vetList = new HashSet<>();



    public void addVet(UserEntity vet) {
        this.vetList.add(vet);
    }

    public void removeVet(long vetId) {
        this.vetList.stream().filter(t -> t.getId() == vetId).findFirst().ifPresent(vet -> this.vetList.remove(vet));
    }
    public StoreDto asStore(){
        return new StoreDto( id, name, address, city, country, owner);
    }
}
