package uz.pdp.cityapartmentservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import uz.pdp.cityapartmentservice.domain.dto.AccommodationCreateDto;
import uz.pdp.cityapartmentservice.domain.entity.house.AccommodationEntity;
import uz.pdp.cityapartmentservice.service.accommodation.AccommodationService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apartment/api/v1/accommodation")
public class AccommodationController {

    private final AccommodationService accommodationService;
    @PostMapping("/add/premium")
    public ResponseEntity<AccommodationEntity> savePremium(
            @Valid @RequestBody AccommodationCreateDto accommodationCreateDto,
            BindingResult bindingResult
    ) {
        return ResponseEntity.ok(accommodationService.savePremiumAccommodation(accommodationCreateDto,bindingResult));
    }

    @PostMapping("/add/economy")
    public ResponseEntity<AccommodationEntity> saveEconomy(
            @Valid @RequestBody AccommodationCreateDto accommodationCreateDto,
            BindingResult bindingResult
    ){
        return ResponseEntity.ok(accommodationService.saveEconomyAccommodation(accommodationCreateDto,bindingResult));
    }

    @GetMapping("/get/byId")
    public ResponseEntity<AccommodationEntity> getById(
            @RequestParam UUID accommodationId
    ){
        return ResponseEntity.ok(accommodationService.getById(accommodationId));
    }

    @GetMapping("/get/byCompany")
    public ResponseEntity<List<AccommodationEntity>> getByCompany(
            @RequestParam UUID companyId
    ){
        return ResponseEntity.ok(accommodationService.getByCompany(companyId));
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<AccommodationEntity>> getAll(){
        return ResponseEntity.ok(accommodationService.getAll());
    }

    @PutMapping("/update/name")
    public ResponseEntity<AccommodationEntity> updateName(
            @RequestParam String newName,
            @RequestParam UUID accommodationId
            ){
        return ResponseEntity.ok(accommodationService.updateName(newName,accommodationId));
    }

    @PutMapping("/update/company")
    public ResponseEntity<AccommodationEntity> updateCompany(
            @RequestParam UUID accommodationId,
            @RequestParam String companyName
    ){
        return ResponseEntity.ok(accommodationService.updateCompany(accommodationId,companyName));
    }

    @DeleteMapping("/delete")
    public HttpStatus delete(
            @RequestParam UUID accommodationId
    ){
        accommodationService.delete(accommodationId);
        return HttpStatus.OK;
    }
}
