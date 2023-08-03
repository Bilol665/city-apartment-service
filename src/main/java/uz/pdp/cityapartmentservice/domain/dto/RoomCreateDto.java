package uz.pdp.cityapartmentservice.domain.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RoomCreateDto {
    private String about;
    private String type;
}
