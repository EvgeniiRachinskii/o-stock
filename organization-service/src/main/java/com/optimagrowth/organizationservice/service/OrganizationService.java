package com.optimagrowth.organizationservice.service;

import com.optimagrowth.organizationservice.model.entity.Organization;
import com.optimagrowth.organizationservice.model.dto.OrganizationRequestDto;;

public interface OrganizationService {

    Organization findById(String organizationId);

    String create(OrganizationRequestDto organizationRequestDto);

    String update(OrganizationRequestDto organizationRequestDto, String organizationId);

    String delete(String organizationId);
}
