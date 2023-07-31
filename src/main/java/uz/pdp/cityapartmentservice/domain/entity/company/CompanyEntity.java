package uz.pdp.cityapartmentservice.domain.entity.company;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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
    private String name;
    private String description;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private CompanyType type;
    private Double balance;
    private UUID ownerId;
}
