package com.neon.hotel.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@AllArgsConstructor@NoArgsConstructor
@Getter
@Setter
@Table(name="hotels")

public class Hotel {

    @Id
    private String id;

    @Column(name = "Hotel_Name",length = 50, nullable = false)
    private  String name;

    @Column(name = "Hotel_Address")
    private String location;

    @Column(name = "About_Hotel",length = 500)
    private  String  about;
}
