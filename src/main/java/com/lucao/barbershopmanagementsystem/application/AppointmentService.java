package com.lucao.barbershopmanagementsystem.application;

import com.lucao.barbershopmanagementsystem.domain.Appointment;
import com.lucao.barbershopmanagementsystem.infrastructure.persistence.appointment.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAllAppointments(){
        return  appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long appointmentId){
        return  appointmentRepository.findById(appointmentId);
    }

    public Appointment createAppointment(Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long appointmentId){
        appointmentRepository.deleteById(appointmentId);
    }

}
