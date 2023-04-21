package com.optimagrowth.licenseserivce.converter;


import com.optimagrowth.licenseserivce.model.dto.LicenseRequestDto;
import com.optimagrowth.licenseserivce.model.entity.License;

public class LicenseConverter {

    public LicenseConverter() {
    }

    public static License toEntity(LicenseRequestDto requestDto) {
        return License
                .builder()
                .licenseCode(requestDto.getLicenseCode())
                .description(requestDto.getDescription())
                .organizationId(requestDto.getOrganizationId())
                .productName(requestDto.getProductName())
                .licenseType(requestDto.getLicenseType())
                .build();

    }
    public static LicenseRequestDto toDto(License license) {
        return LicenseRequestDto
                .builder()
                .licenseCode(license.getLicenseCode())
                .description(license.getDescription())
                .organizationId(license.getOrganizationId())
                .productName(license.getProductName())
                .licenseType(license.getLicenseType())
                .build();

    }
}
