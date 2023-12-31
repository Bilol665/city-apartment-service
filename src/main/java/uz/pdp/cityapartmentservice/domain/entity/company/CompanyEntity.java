package uz.pdp.cityapartmentservice.domain.entity.company;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.cityapartmentservice.domain.entity.BaseEntity;

import java.util.UUID;

@Entity(name = "companies")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class CompanyEntity extends BaseEntity {
    @Column(unique = true)
    private String name;
    private String description;
    private UUID ownerId;
}
