package com.lucao.barbershopmanagementsystem.application.appointment;

import com.lucao.barbershopmanagementsystem.application.AppointmentService;
import com.lucao.barbershopmanagementsystem.domain.Appointment;
import com.lucao.barbershopmanagementsystem.infrastructure.persistence.appointment.AppointmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class AppointmentServiceTest {

    @Mock
    private AppointmentRepository appointmentRepository;

    @InjectMocks
    private AppointmentService appointmentService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void testGetAppointmentById(){
        long appointmentId = 1L;
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(appointmentId);

        when(appointmentRepository.findById(appointmentId))
                .thenReturn(Optional.of(appointment));

        Optional<Appointment> result = appointmentService.getAppointmentById(appointmentId);

        assertEquals(Optional.of(appointment), result);
        verify(appointmentRepository, times(1)).findById(appointmentId);
    }
}
