package uz.pdp.cityapartmentservice.domain.dto;


import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserDto {
    private UUID userid;
    private String email;
}
