package com.optimagrowth.licenseserivce.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.security.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "licences")
public class License extends RepresentationModel<License> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //  @Column(unique = true)
    private String licenseCode;
    private String description;
    private String organizationId;
    private String productName;
    private String licenseType;
    private String organizationName;
}
