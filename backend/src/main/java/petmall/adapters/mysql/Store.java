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
                    CascadeType.MERGE
            })
    @JoinTable(name = "tutorial_tags",
            joinColumns = { @JoinColumn(name = "tutorial_id") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id") })
    private Set<Vet> vetList= new HashSet<>();



    public void addVet(Vet vet) {
        this.vetList.add(vet);
    }

    public void removeVet(long vetId) {
        Vet vet = this.vetList.stream().filter(t -> t.getId() == vetId).findFirst().orElse(null);
        if (vet != null) {
            this.vetList.remove(vet);
        }
    }
    public StoreDto asStore(){
        return new StoreDto( name, address, city, country, owner);
    }
}
