package com.optimagrowth.licenseserivce.service;

import com.optimagrowth.licenseserivce.model.dto.LicenseRequestDto;
import com.optimagrowth.licenseserivce.model.entity.License;

import java.util.concurrent.TimeoutException;

public interface LicenseService {

    License getLicense(String licenseCode,String organizationId) throws TimeoutException;

    String createLicense(LicenseRequestDto requestDto, String organizationId);

    String updateLicense(LicenseRequestDto requestDto, String organizationId);

    String deleteLicense(String licenseCode,String organizationId);
}
