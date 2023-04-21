package com.optimagrowth.organizationservice.controller;

import com.optimagrowth.organizationservice.model.entity.Organization;
import com.optimagrowth.organizationservice.model.dto.OrganizationRequestDto;
import com.optimagrowth.organizationservice.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "v1/organization")
public class OrganizationController {

    private final OrganizationService organizationService;


    @GetMapping("/{organizationId}")
    public ResponseEntity<Organization> getOrganization(@PathVariable("organizationId") String organizationId) {
        return ResponseEntity.ok(organizationService.findById(organizationId));
    }

    @PutMapping("/{organizationId}")
    public void updateOrganization(@PathVariable("organizationId") String organizationId,
                                   @RequestBody OrganizationRequestDto organizationRequestDto) {
        organizationService.update(organizationRequestDto, organizationId);
    }

    @PostMapping
    public ResponseEntity<String> saveOrganization(@RequestBody OrganizationRequestDto organizationRequestDto) {

        return ResponseEntity.ok(organizationService.create(organizationRequestDto));
    }

    @DeleteMapping("/{organizationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganization(@PathVariable("id") String organizationId) {
        organizationService.delete(organizationId);
    }

}