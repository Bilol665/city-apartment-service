package uz.pdp.cityapartmentservice.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import uz.pdp.cityapartmentservice.domain.dto.CompanyCreateDto;
import uz.pdp.cityapartmentservice.domain.entity.company.CompanyEntity;
import uz.pdp.cityapartmentservice.service.company.CompanyService;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apartment/api/v1/company")
public class CompanyController {

    private final CompanyService companyService;

    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<CompanyEntity> add(
            Principal principal,
            @Valid @RequestBody CompanyCreateDto companyCreateDto,
            BindingResult bindingResult
    ){
        return ResponseEntity.ok(companyService.save(principal,companyCreateDto,bindingResult));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<CompanyEntity> get(
            @PathVariable UUID id
    ) {
        return ResponseEntity.ok(companyService.get(id));
    }
    @GetMapping("/{userId}/get")
    public ResponseEntity<List<CompanyEntity>> getList(
            @PathVariable UUID userId
    ) {
        return ResponseEntity.ok(companyService.getList(userId));
    }
}
