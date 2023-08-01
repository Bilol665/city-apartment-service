package uz.pdp.cityapartmentservice.domain.entity.company;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "company_type")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CompanyType {
    @Id
    @Column(unique = true)
    private String type;
}
