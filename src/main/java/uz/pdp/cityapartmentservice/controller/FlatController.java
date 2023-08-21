package uz.pdp.cityapartmentservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.cityapartmentservice.domain.entity.house.FlatEntity;
import uz.pdp.cityapartmentservice.service.flat.FlatService;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apartment/api/v1/flat")
public class FlatController {
    private final FlatService flatService;

    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @PutMapping ("/update/setOwner")
    public ResponseEntity<FlatEntity> setOwner(
            Principal principal,
            @RequestParam UUID flatId
    ){
        return ResponseEntity.ok(flatService.setOwner(principal,flatId));
    }
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @PutMapping("/update/{flatId}/removeOwner")
    public ResponseEntity<FlatEntity> removeOwner(
            @PathVariable UUID flatId
    ){
        return ResponseEntity.ok(flatService.removeOwner(flatId));
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/get/{id}/accommodation")
    public ResponseEntity<List<FlatEntity>> getByAccommodationId(
            @PathVariable UUID id
    ){
        return ResponseEntity.ok(flatService.getAll(id));
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/get/{id}")
    public ResponseEntity<FlatEntity> getFlat(
            @PathVariable UUID id
    ){
        return ResponseEntity.ok(flatService.getFlat(id));
    }
}
