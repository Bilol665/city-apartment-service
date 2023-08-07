package uz.pdp.cityapartmentservice.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.cityapartmentservice.domain.dto.CompanyCreateDto;
import uz.pdp.cityapartmentservice.domain.entity.company.CompanyEntity;
import uz.pdp.cityapartmentservice.service.company.CompanyService;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apartment/api/v1/company")
public class CompanyController {

    private final CompanyService companyService;

   // @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<CompanyEntity> add(
            Principal principal,
            @Valid @RequestBody CompanyCreateDto companyCreateDto,
            BindingResult bindingResult
    ){
        return ResponseEntity.ok(companyService.save(principal,companyCreateDto,bindingResult));
    }
}
