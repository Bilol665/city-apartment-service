package uz.pdp.cityapartmentservice.service.company;

import lombok.RequiredArgsConstructor;
import org.jvnet.hk2.annotations.Service;
import uz.pdp.cityapartmentservice.repository.company.CompanyRepository;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
}
