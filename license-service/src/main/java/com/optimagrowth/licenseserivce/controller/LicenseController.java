package com.optimagrowth.licenseserivce.controller;

import com.optimagrowth.licenseserivce.model.dto.LicenseRequestDto;
import com.optimagrowth.licenseserivce.model.entity.License;
import com.optimagrowth.licenseserivce.service.LicenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.concurrent.TimeoutException;

import static com.optimagrowth.licenseserivce.converter.LicenseConverter.toDto;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@Slf4j
@RestController
@RequestMapping("v1/organization/{organizationId}/license")
@RequiredArgsConstructor
public class LicenseController {



    private final LicenseService licenseService;


    @GetMapping(value = "/{licenseCode}")
    public ResponseEntity<License> getLicense(@PathVariable("organizationId") String organizationId,
                                              @PathVariable("licenseCode") String licenseCode) throws TimeoutException {
        License license = licenseService.getLicense(licenseCode, organizationId);
        license.add(linkTo(methodOn(LicenseController.class)
                        .getLicense(organizationId, license.getLicenseCode()))
                        .withSelfRel()
                , linkTo(methodOn(LicenseController.class).createLicense(organizationId, toDto(license))).withRel("createLicense")
                , linkTo(methodOn(LicenseController.class).updateLicense(organizationId, toDto(license))).withRel("updateLicense")
                , linkTo(methodOn(LicenseController.class).deleteLicense(organizationId, license.getLicenseCode())).withRel("deleteLicense"));
        return ResponseEntity.ok(license);

    }

    @PutMapping
    public ResponseEntity<String> updateLicense(@PathVariable("organizationId") String organizationId,
                                                @RequestBody LicenseRequestDto requestDto) {
        return ResponseEntity.ok(licenseService.updateLicense(requestDto, organizationId));
    }

    @PostMapping
    public ResponseEntity<String> createLicense(@PathVariable("organizationId") String organizationId,
                                                @RequestBody LicenseRequestDto requestDto) {
        log.info("License with code {} successfully created at {}",requestDto.getLicenseCode(), LocalDateTime.now());
        return ResponseEntity.ok(licenseService.createLicense(requestDto, organizationId));

    }

    @DeleteMapping(value = "/{licenseCode}")
    public ResponseEntity<String> deleteLicense(@PathVariable("organizationId") String organizationId,
                                                @PathVariable("licenseCode") String licenseCode) {
        return ResponseEntity.ok(licenseService.deleteLicense(licenseCode, organizationId));
    }

}
