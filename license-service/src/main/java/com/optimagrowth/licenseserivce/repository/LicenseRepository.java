package com.optimagrowth.licenseserivce.repository;

import com.optimagrowth.licenseserivce.model.entity.License;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LicenseRepository extends JpaRepository<License,Long> {

    Optional<License> findLicenseByLicenseCodeAndOrganizationId(String licenseCode,String organizationId);

    void deleteLicenseByLicenseCodeAndOrganizationId(String licenseCode,String organizationId);


}
