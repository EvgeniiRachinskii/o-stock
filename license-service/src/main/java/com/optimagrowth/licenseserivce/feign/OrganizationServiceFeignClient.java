package com.optimagrowth.licenseserivce.feign;

import com.optimagrowth.licenseserivce.feign.fallback.OrganizationServiceFallbackFactory;
import com.optimagrowth.licenseserivce.model.dto.OrganizationRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "organization-service", fallbackFactory = OrganizationServiceFallbackFactory.class)
public interface OrganizationServiceFeignClient {

    @GetMapping("v1/organization/{organizationId}")
    ResponseEntity<OrganizationRequestDto> getOrganization(@PathVariable("organizationId") String organizationId);

}
