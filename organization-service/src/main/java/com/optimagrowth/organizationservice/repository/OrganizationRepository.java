package com.optimagrowth.organizationservice.repository;

import com.optimagrowth.organizationservice.model.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Optional<Organization> findById(String organizationId);

    void deleteById(String organizationId);

}
