package com.lucao.barbershopmanagementsystem.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "appointment")
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Barber barber;

    private String serviceType;

    private LocalDate dateTime;
}
