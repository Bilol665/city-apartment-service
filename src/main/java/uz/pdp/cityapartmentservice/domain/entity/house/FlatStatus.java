package uz.pdp.cityapartmentservice.domain.entity.house;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "flat_status")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FlatStatus {
    @Id
    @Column(unique = true)
    private String status;
}
