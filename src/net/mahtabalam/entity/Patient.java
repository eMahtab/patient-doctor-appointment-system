package net.mahtabalam.entity;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private String name;
    private List<Appointment> bookedAppointments = new ArrayList<>();

    public Patient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void addAppointment(Appointment appointment) {
    	bookedAppointments.add(appointment);
    }
    
    public void removeAppointment(Appointment appointment) {
    	bookedAppointments.remove(appointment);
    }

    public List<Appointment> getBookedAppointments() {
        return bookedAppointments;
    }
}