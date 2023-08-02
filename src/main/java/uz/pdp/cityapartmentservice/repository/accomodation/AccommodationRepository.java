package uz.pdp.cityapartmentservice.repository.accomodation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.cityapartmentservice.domain.entity.house.AccommodationEntity;

import java.util.UUID;

@Repository
public interface AccommodationRepository extends JpaRepository<AccommodationEntity, UUID> {
}
