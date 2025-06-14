package com.srt.accounts.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "cab_driver")
@Data
public class CabDriver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //to use auto-incrementing IDs
    @Column(name = "id")
    private Long id;
    @Column(name = "driver_name", nullable = false)
    private String driverName;
    @Column(name = "driver_address", nullable = false)
    private String driverAddress;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "gender")
    private String gender;
}
