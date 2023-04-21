package com.optimagrowth.organizationservice.feign.fallback;

import com.optimagrowth.licenseserivce.exceptions.FeignRequestException;
import com.optimagrowth.licenseserivce.feign.OrganizationServiceFeignClient;
import com.optimagrowth.licenseserivce.model.dto.OrganizationRequestDto;
import org.springframework.http.ResponseEntity;

record OrganizationServiceFallback(Throwable cause) implements OrganizationServiceFeignClient {
    @Override
    public ResponseEntity<OrganizationRequestDto> getOrganization(String organizationId) {
        throw new FeignRequestException("Service is not available right now caused by : ->%s ".formatted(cause.getMessage()), cause);
    }


}
