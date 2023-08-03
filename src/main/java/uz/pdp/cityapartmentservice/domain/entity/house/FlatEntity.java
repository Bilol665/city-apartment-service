package uz.pdp.cityapartmentservice.domain.entity.house;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import uz.pdp.cityapartmentservice.domain.entity.BaseEntity;
import uz.pdp.cityapartmentservice.domain.entity.room.RoomEntity;

import java.util.List;
import java.util.UUID;


@Entity(name = "flats")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class FlatEntity extends BaseEntity {
    private Integer number;
    private Integer whichFloor;
    private FlatType flatType;
    @OneToMany
    private List<RoomEntity> rooms;
    private UUID ownerId;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private FlatStatus status;
    private String about;
    private Double price;
}
