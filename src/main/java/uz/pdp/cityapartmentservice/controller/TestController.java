package uz.pdp.cityapartmentservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.cityapartmentservice.domain.dto.AccommodationCreateDto;
import uz.pdp.cityapartmentservice.domain.entity.house.AccommodationEntity;
import uz.pdp.cityapartmentservice.service.accommodation.AccommodationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apartment")
public class TestController {
    private final AccommodationService accommodationService;

    @PostMapping("/add")
    public ResponseEntity<AccommodationEntity> save(
            @Valid @RequestBody AccommodationCreateDto accommodationCreateDto,
            BindingResult bindingResult
    ) {
        return ResponseEntity.ok(accommodationService.save(accommodationCreateDto));
    }
}
