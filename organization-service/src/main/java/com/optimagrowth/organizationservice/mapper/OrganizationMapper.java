package com.optimagrowth.organizationservice.mapper;

import com.optimagrowth.organizationservice.model.entity.Organization;
import com.optimagrowth.organizationservice.model.dto.OrganizationRequestDto;

public class OrganizationMapper {
    public OrganizationMapper() {
    }


    public static Organization toEntity(OrganizationRequestDto dto) {
        return Organization.builder()
                .name(dto.getName())
                .contactEmail(dto.getContactEmail())
                .contactPhone(dto.getContactPhone())
                .contactName(dto.getContactName())
                .build();
    }
}
