package uz.pdp.cityapartmentservice.service.accommodation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.cityapartmentservice.domain.dto.AccommodationCreateDto;
import uz.pdp.cityapartmentservice.domain.entity.house.AccommodationEntity;
import uz.pdp.cityapartmentservice.repository.accomodation.AccommodationRepository;

@Service
@RequiredArgsConstructor
public class AccommodationService {
    private final AccommodationRepository accommodationRepository;
    private final ModelMapper modelMapper;

    public AccommodationEntity save(AccommodationCreateDto accommodationCreateDto) {
        AccommodationEntity map = modelMapper.map(accommodationCreateDto, AccommodationEntity.class);
        return accommodationRepository.save(map);
    }
}
