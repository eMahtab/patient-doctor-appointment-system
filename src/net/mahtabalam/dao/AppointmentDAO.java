package net.mahtabalam.dao;

import java.util.HashMap;
import java.util.Map;

import net.mahtabalam.entity.Appointment;

public class AppointmentDAO {
    private Map<String, Appointment> appointmentsById = new HashMap<>();
    
    public void saveAppointment(Appointment appointment) {
        appointmentsById.put(appointment.getAppointmentId(), appointment);
    }
    
    public Appointment findAppointmentById(String bookingId) {
        return appointmentsById.get(bookingId);
    }
    
    public void deleteAppointment(String bookingId) {
        appointmentsById.remove(bookingId);
    }
}