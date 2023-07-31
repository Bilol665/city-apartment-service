package uz.pdp.cityapartmentservice.domain.entity.house;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;
import uz.pdp.cityapartmentservice.domain.dto.Location;
import uz.pdp.cityapartmentservice.domain.entity.BaseEntity;
import uz.pdp.cityapartmentservice.domain.entity.company.CompanyEntity;
import uz.pdp.cityapartmentservice.domain.entity.room.RoomEntity;

import java.util.List;

@Entity(name = "accommodations")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccommodationEntity extends BaseEntity {
    private String name;
    @OneToOne
    private Location location;
    private Integer numberOfFlats;
    private Integer floors;
    private Integer numberOfEntrances;
    @ManyToOne
    private CompanyEntity company;
    @OneToMany
    private List<FlatEntity> rooms;
}
