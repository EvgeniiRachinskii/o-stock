package com.optimagrowth.organizationservice.service.impl;

import com.optimagrowth.organizationservice.mapper.OrganizationMapper;
import com.optimagrowth.organizationservice.model.entity.Organization;
import com.optimagrowth.organizationservice.model.dto.OrganizationRequestDto;
import com.optimagrowth.organizationservice.repository.OrganizationRepository;
import com.optimagrowth.organizationservice.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

import static com.optimagrowth.organizationservice.util.ApiValidationUtil.requiredTrue;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository organizationRepository;

    public Organization findById(String organizationId) {
        Optional<Organization> opt = organizationRepository.findById(organizationId);
        return (opt.isPresent()) ? opt.get() : null;
    }

    public String create(OrganizationRequestDto organizationRequestDto) {
        Organization organization = OrganizationMapper.toEntity(organizationRequestDto);
        organizationRepository.save(organization);
        return "Organization successfully created";

    }

    public String update(OrganizationRequestDto organizationRequestDto, String organizationId) {
        Optional<Organization> optionalOrganization = organizationRepository.findById(organizationId);
        requiredTrue(optionalOrganization.isPresent(), "There is no organization with id : " + organizationId);
        Organization organization = OrganizationMapper.toEntity(organizationRequestDto);
        organizationRepository.save(organization);
        return "Organization successfully updated";
    }

    public String delete(String organizationId) {
        organizationRepository.deleteById(organizationId);
        return "License successfully deleted";
    }
}
