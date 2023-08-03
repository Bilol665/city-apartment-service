package uz.pdp.cityapartmentservice.service.flat;

import lombok.RequiredArgsConstructor;
import org.jvnet.hk2.annotations.Service;
import uz.pdp.cityapartmentservice.repository.flat.FlatRepository;

@Service
@RequiredArgsConstructor
public class FlatService  {
    private final FlatRepository flatRepository;
}
