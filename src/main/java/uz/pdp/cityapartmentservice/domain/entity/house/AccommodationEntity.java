package uz.pdp.cityapartmentservice.domain.entity.house;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.cityapartmentservice.domain.dto.LocationEntity;
import uz.pdp.cityapartmentservice.domain.entity.BaseEntity;
import uz.pdp.cityapartmentservice.domain.entity.company.CompanyEntity;

import java.util.List;

@Entity(name = "accommodations")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccommodationEntity extends BaseEntity {
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private LocationEntity locationEntity;
    private Integer numberOfFlats;
    private Integer floors;
    @ManyToOne
    private CompanyEntity company;
    @OneToMany
    private List<FlatEntity> flats;
}
