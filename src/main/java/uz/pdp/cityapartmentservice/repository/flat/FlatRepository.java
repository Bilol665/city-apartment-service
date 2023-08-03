package uz.pdp.cityapartmentservice.repository.flat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.cityapartmentservice.domain.entity.house.FlatEntity;

import java.util.UUID;

@Repository
public interface FlatRepository extends JpaRepository<FlatEntity, UUID> {
}
