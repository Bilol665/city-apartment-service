package uz.pdp.cityapartmentservice.domain.dto;

import jakarta.persistence.Entity;
import lombok.*;
import uz.pdp.cityapartmentservice.domain.entity.BaseEntity;

@Entity(name = "locations")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class LocationEntity extends BaseEntity {
    private Double longitude;
    private Double latitude;
}
