package com.optimagrowth.licenseserivce.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LicenseRequestDto {
    private String licenseCode;
    private String description;
    private String organizationId;
    private String productName;
    private String licenseType;
}
