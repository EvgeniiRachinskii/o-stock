package com.optimagrowth.organizationservice.model.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrganizationRequestDto {

    private String name;
    private String contactName;
    private String contactEmail;
    private String contactPhone;

}
