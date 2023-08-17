package uz.pdp.cityapartmentservice.service.company;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import uz.pdp.cityapartmentservice.domain.dto.CompanyCreateDto;
import uz.pdp.cityapartmentservice.domain.dto.UserReadDto;
import uz.pdp.cityapartmentservice.domain.entity.company.CompanyEntity;
import uz.pdp.cityapartmentservice.exceptions.DataNotFound;
import uz.pdp.cityapartmentservice.exceptions.RequestValidationException;
import uz.pdp.cityapartmentservice.repository.company.CompanyRepository;
import uz.pdp.cityapartmentservice.service.user.AuthService;

import java.security.Principal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final AuthService authService;
    private final ModelMapper modelMapper;

    public CompanyEntity save(Principal principal, CompanyCreateDto companyCreateDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new RequestValidationException(bindingResult.getAllErrors());
        }
        UserReadDto user = authService.getUser(principal.getName(),principal);
        CompanyEntity companyEntity = modelMapper.map(companyCreateDto, CompanyEntity.class);

        companyEntity.setOwnerId(user.getId());
        return companyRepository.save(companyEntity);
    }

    public CompanyEntity getByName(String name) {
        return companyRepository.findByName(name)
                .orElseThrow(() -> new DataNotFound("Company Not Found"));
    }

    public CompanyEntity get(UUID id) {
        return companyRepository.findById(id).orElseThrow(() -> new DataNotFound("Company not found!"));
    }
}
