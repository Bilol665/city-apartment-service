package uz.pdp.cityapartmentservice.service.flat;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.cityapartmentservice.domain.dto.UserReadDto;
import uz.pdp.cityapartmentservice.domain.entity.house.FlatEntity;
import uz.pdp.cityapartmentservice.domain.entity.house.FlatStatus;
import uz.pdp.cityapartmentservice.exceptions.DataNotFound;
import uz.pdp.cityapartmentservice.repository.accomodation.AccommodationRepository;
import uz.pdp.cityapartmentservice.repository.flat.FlatRepository;
import uz.pdp.cityapartmentservice.service.user.AuthService;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FlatService  {
    private final AccommodationRepository accommodationRepository;
    private final FlatRepository flatRepository;
    private final AuthService authService;

    public FlatEntity setOwner(Principal principal, UUID flatId){
        FlatEntity flat = flatRepository.findById(flatId)
                .orElseThrow(() -> new DataNotFound("Flat Not Found"));
        UserReadDto user = authService.getUser(principal.getName());
        flat.setOwnerId(user.getId());
        flat.setStatus(FlatStatus.BUSY);
        return flatRepository.save(flat);
    }

    public FlatEntity removeOwner(UUID flatId){
        FlatEntity flat = flatRepository.findById(flatId)
                .orElseThrow(() -> new DataNotFound("Flat Not Found!"));
        flat.setOwnerId(flat.getCompany().getId());
        flat.setStatus(FlatStatus.AVAILABLE);
        return flatRepository.save(flat);
    }

    public List<FlatEntity> getAll(UUID id) {
        return accommodationRepository.findById(id)
                .orElseThrow(()-> new DataNotFound("Accommodation Not Found"))
                .getFlats();
    }
}
