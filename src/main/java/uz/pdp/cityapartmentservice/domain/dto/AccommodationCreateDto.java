package uz.pdp.cityapartmentservice.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class AccommodationCreateDto {
    @NotBlank(message = "Name must be present")
    private String name;
    @NotNull(message = "Location must be present")
    private LocationEntity locationEntity;
    @NotNull(message = "Company ID must be present")
    private UUID companyId;
}
