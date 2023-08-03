package uz.pdp.cityapartmentservice.service.accommodation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.cityapartmentservice.domain.dto.AccommodationCreateDto;
import uz.pdp.cityapartmentservice.domain.entity.company.CompanyEntity;
import uz.pdp.cityapartmentservice.domain.entity.house.AccommodationEntity;
import uz.pdp.cityapartmentservice.domain.entity.house.FlatEntity;
import uz.pdp.cityapartmentservice.domain.entity.house.FlatType;
import uz.pdp.cityapartmentservice.domain.entity.room.RoomEntity;
import uz.pdp.cityapartmentservice.domain.entity.room.RoomType;
import uz.pdp.cityapartmentservice.exceptions.DataNotFound;
import uz.pdp.cityapartmentservice.repository.accomodation.AccommodationRepository;
import uz.pdp.cityapartmentservice.repository.company.CompanyRepository;
import uz.pdp.cityapartmentservice.repository.flat.FlatRepository;
import uz.pdp.cityapartmentservice.repository.room.RoomRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccommodationService {
    private final AccommodationRepository accommodationRepository;
    private final CompanyRepository companyRepository;
    private final FlatRepository flatRepository;
    private final RoomRepository roomRepository;
    private final ModelMapper modelMapper;

    public AccommodationEntity savePremiumAccommodation(AccommodationCreateDto accommodationCreateDto) {
        AccommodationEntity accommodation = modelMapper.map(accommodationCreateDto, AccommodationEntity.class);

        CompanyEntity companyEntity = companyRepository.findById(accommodationCreateDto.getCompanyId())
                .orElseThrow(() -> new DataNotFound("Company Not Found!"));

        List<FlatEntity> flats = new ArrayList<>();
        int number = 1;
        int floor = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                RoomEntity bedroom = RoomEntity.builder()
                        .about("5x5")
                        .type(RoomType.BEDROOM)
                        .build();
                RoomEntity kitchen = RoomEntity.builder()
                        .type(RoomType.KITCHEN)
                        .about("4x5")
                        .build();
                RoomEntity livingRoom = RoomEntity.builder()
                        .about("6x5")
                        .type(RoomType.LIVING_ROOM)
                        .build();
                RoomEntity childrenRoom = RoomEntity.builder()
                        .type(RoomType.CHILDREN_ROOM)
                        .about("4x3")
                        .build();
                RoomEntity diningRoom = RoomEntity.builder()
                        .about("4x4")
                        .type(RoomType.DINING_ROOM)
                        .build();
                RoomEntity bathroom = RoomEntity.builder()
                        .about("3x3")
                        .type(RoomType.BATHROOM)
                        .build();


                roomRepository.save(bathroom);
                roomRepository.save(bedroom);
                roomRepository.save(livingRoom);
                roomRepository.save(diningRoom);
                roomRepository.save(childrenRoom);
                roomRepository.save(kitchen);
                FlatEntity premiumFlat1 = FlatEntity.builder()
                        .about("Premium flat which includes 6 rooms")
                        .rooms(List.of(bedroom, kitchen, livingRoom, childrenRoom, diningRoom, bathroom))
                        .number(number++)
                        .price(1000.0)
                        .whichFloor(floor)
                        .flatType(FlatType.PREMIUM)
                        .build();
                flatRepository.save(premiumFlat1);
                flats.add(premiumFlat1);
            }
            floor++;
        }

        accommodation.setFlats(flats);
        accommodation.setFloors(4);
        accommodation.setCompany(companyEntity);
        accommodation.setNumberOfFlats(8);
        accommodation.setLocationEntity(accommodationCreateDto.getLocationEntity());
        accommodation.setName(accommodationCreateDto.getName());

        return accommodationRepository.save(accommodation);

    }
}
