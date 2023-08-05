package uz.pdp.cityapartmentservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.cityapartmentservice.domain.entity.house.FlatEntity;
import uz.pdp.cityapartmentservice.service.flat.FlatService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accommodation/api/v1/flat")
public class FlatController {
    private final FlatService flatService;

    @PutMapping ("/update/setOwner")
    public ResponseEntity<FlatEntity> setOwner(
            @RequestParam UUID ownerId,
            @RequestParam UUID flatId
    ){
        return ResponseEntity.ok(flatService.setOwner(ownerId,flatId));
    }

    @PutMapping("/update/removeOwner")
    public ResponseEntity<FlatEntity> removeOwner(
            @RequestParam UUID flatId
    ){
        return ResponseEntity.ok(flatService.removeOwner(flatId));
    }
}
