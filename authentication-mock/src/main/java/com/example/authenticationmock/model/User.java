package com.example.authenticationmock.model;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private byte age;
    private byte level;
    private String name;
}