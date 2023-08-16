package uz.pdp.cityapartmentservice.repository.token;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.cityapartmentservice.domain.entity.token.JwtTokenEntity;

public interface JwtTokenRepository extends JpaRepository<JwtTokenEntity,String> {
}
