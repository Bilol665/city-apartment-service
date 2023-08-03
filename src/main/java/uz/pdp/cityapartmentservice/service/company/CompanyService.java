package uz.pdp.cityapartmentservice.service.company;

import lombok.RequiredArgsConstructor;
import org.jvnet.hk2.annotations.Service;
import uz.pdp.cityapartmentservice.domain.entity.company.CompanyEntity;
import uz.pdp.cityapartmentservice.exceptions.DataNotFound;
import uz.pdp.cityapartmentservice.repository.company.CompanyRepository;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyEntity getByName(String name) {
        return companyRepository.findByName(name)
                .orElseThrow(() -> new DataNotFound("Company Not Found"));
    }
}
