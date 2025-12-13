package com.neon.user.service.entities;

import jakarta.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "micro_users")
public class User {

    @Id
    @Column(name="ID")
    private String userId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ABOUT_USER")
    private String about;

    // store in another microservices so we use @transient keyword
    @Transient
    private List<Rating> rating= new ArrayList<>();



}
