package uz.pdp.cityapartmentservice.domain.entity.room;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import uz.pdp.cityapartmentservice.domain.entity.BaseEntity;

@Entity(name = "rooms")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class RoomEntity extends BaseEntity {
    private Integer size;
    @ManyToOne(cascade = CascadeType.ALL)
    private RoomType type;
}
