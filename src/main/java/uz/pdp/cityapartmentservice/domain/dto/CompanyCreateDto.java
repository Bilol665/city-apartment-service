package uz.pdp.cityapartmentservice.domain.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CompanyCreateDto {
    @NotBlank(message = "Name must be present")
    private String name;
    @NotBlank(message = "Description must be present")
    private String description;
    @NotNull(message = "Owner must be present")
    private UUID ownerId;
}
