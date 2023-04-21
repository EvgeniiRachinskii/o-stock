package com.optimagrowth.licenseserivce.service;

import com.optimagrowth.licenseserivce.feign.OrganizationServiceFeignClient;
import com.optimagrowth.licenseserivce.model.dto.LicenseRequestDto;
import com.optimagrowth.licenseserivce.model.dto.OrganizationRequestDto;
import com.optimagrowth.licenseserivce.model.entity.License;
import com.optimagrowth.licenseserivce.repository.LicenseRepository;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

import static com.optimagrowth.licenseserivce.converter.LicenseConverter.toEntity;
import static com.optimagrowth.licenseserivce.util.ApiValidationUtil.requiredTrue;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class LicenseServiceImpl implements LicenseService {

    private final OrganizationServiceFeignClient organizationServiceFeignClient;
    private final LicenseRepository licenseRepository;

    /**
     * simulation of artificial delay
     */

    /**
     * private void randomlyRunLong() throws TimeoutException{
     * sleep();
     * }
     * private void sleep() throws TimeoutException{
     * try {
     * System.out.println("Sleep");
     * Thread.sleep(5000);
     * throw new java.util.concurrent.TimeoutException();
     * } catch (InterruptedException e) {
     * log.error(e.getMessage());
     * }
     * }
     */


    @CircuitBreaker(name = "licenseService", fallbackMethod = "buildFallbackLicense")
    @Bulkhead(name = "bulkhead", type = Bulkhead.Type.THREADPOOL, fallbackMethod = "buildFallbackLicense")
    // ограничивает одновременное кол-во вызовов
    @Retry(name = "retry", fallbackMethod = "buildFallbackLicense")
    @RateLimiter(name = "rateLimiter", fallbackMethod = "buildFallbackLicense") // ограничивает общее кол - во вызовов
    @Override
    public License getLicense(String licenseCode, String organizationId) throws TimeoutException {

        OrganizationRequestDto organizationRequestDto = organizationServiceFeignClient.getOrganization(organizationId).getBody();
        requiredTrue(organizationRequestDto.getId() != null, "organization is not exists ");
        Optional<License> licenseOptional = licenseRepository.findLicenseByLicenseCodeAndOrganizationId(licenseCode, organizationRequestDto.getId());
        requiredTrue(licenseOptional.isPresent(), "There is no license with this license code : " + licenseCode);
        License license = licenseOptional.get();
        license.setOrganizationName(organizationRequestDto.getName());
        // randomlyRunLong();
       // log.debug("LicenseServiceController Correlation id: {}",
              //  UserContextHolder.getContext().getCorrelationId());
        return license;
    }

    private License buildFallbackLicense(String licenseCode, String organizationId, Throwable t) {
        return License
                .builder()
                .licenseCode(licenseCode)
                .organizationId(organizationId)
                .licenseType("there is no license type")
                .organizationName("there is no organization name")
                .productName("there is no product name")
                .description("sorry no license information currently available, please try again later")
                .build();

    }

    @Override
    public String createLicense(LicenseRequestDto requestDto, String organizationId) {
        License license = toEntity(requestDto);
        OrganizationRequestDto organizationRequestDto = organizationServiceFeignClient.getOrganization(organizationId).getBody();
        requiredTrue(organizationRequestDto.getId() != null, "organization is not exists ");
        license.setOrganizationName(organizationRequestDto.getName());
        licenseRepository.save(license);
        log.info(String.format("License saved to db with license code {}", license.getLicenseCode()));
        return "License successfully created";
    }

    @Override
    public String updateLicense(LicenseRequestDto requestDto, String organizationId) {
        Optional<License> optionalLicense = licenseRepository.findLicenseByLicenseCodeAndOrganizationId(requestDto.getLicenseCode(), organizationId);
        License license = optionalLicense.get();
        license.setDescription(requestDto.getDescription());
        licenseRepository.save(license);
        log.info(String.format("License updated license code {}", license.getLicenseCode()));
        return "License successfully updated";
    }

    @Override
    public String deleteLicense(String licenseCode, String organizationId) {
        licenseRepository.deleteLicenseByLicenseCodeAndOrganizationId(licenseCode, organizationId);
        log.info(String.format("License saved to db with license code {}", licenseCode));
        return "License successfully deleted";
    }
}
