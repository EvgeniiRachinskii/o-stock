package com.optimagrowth.organizationservice.feign.fallback;

import com.optimagrowth.licenseserivce.feign.OrganizationServiceFeignClient;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class OrganizationServiceFallbackFactory implements FallbackFactory<OrganizationServiceFeignClient> {

    @Override
    public OrganizationServiceFallback create(Throwable cause) {
        return new OrganizationServiceFallback(cause);
    }
}
