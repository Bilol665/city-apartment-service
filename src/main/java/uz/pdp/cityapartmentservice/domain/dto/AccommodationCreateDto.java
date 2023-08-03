package uz.pdp.cityapartmentservice.domain.dto;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class AccommodationCreateDto {
    private String name;
    //private Location location;
    private UUID companyId;
}
