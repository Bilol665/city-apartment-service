package uz.pdp.cityapartmentservice.service.flat;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.cityapartmentservice.domain.entity.house.FlatEntity;
import uz.pdp.cityapartmentservice.domain.entity.house.FlatStatus;
import uz.pdp.cityapartmentservice.exceptions.DataNotFound;
import uz.pdp.cityapartmentservice.repository.flat.FlatRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FlatService  {
    private final FlatRepository flatRepository;

    public FlatEntity setOwner(UUID ownerId,UUID flatId){
        FlatEntity flat = flatRepository.findById(flatId)
                .orElseThrow(() -> new DataNotFound("Flat Not Found"));
        flat.setOwnerId(ownerId);
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
}
