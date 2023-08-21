package uz.pdp.cityapartmentservice.repository.company;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.cityapartmentservice.domain.entity.company.CompanyEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {
    Optional<CompanyEntity> findByOwnerId (UUID ownerId);
    List<CompanyEntity> findCompanyEntitiesByOwnerId(UUID ownerId);
}
