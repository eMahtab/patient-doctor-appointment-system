package net.mahtabalam.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Doctor {
    private String name;
    private Speciality speciality;
    private Set<String> availableSlots;
    private List<Appointment> bookedAppointments;

    public Doctor(String name, Speciality speciality) {
        this.name = name;
        this.speciality = speciality;
        this.availableSlots = new HashSet<>();
        this.bookedAppointments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public Set<String> getAvailability() {
        return availableSlots;
    }

    public List<Appointment> getBookedAppointments() {
        return bookedAppointments;
    }

    public boolean markAvailability(String slot) {
        if (isValidSlot(slot)) {
        	availableSlots.add(slot); // adding back the time slot to the availableSlots Set
            return true;
        }
        System.out.println("Sorry Dr. " + this.name + " slots are 60 mins only");
        return false;
    }
    
    public void removeAvailability(String slot) {
        availableSlots.remove(slot);
    }

    private boolean isValidSlot(String slot) {
        // Simplified check to make sure slot duration is 1 hour based on time difference
        String[] times = slot.split("-");
        String startTime = times[0];
        String[] t1 = startTime.split(":");
        int h1 = Integer.parseInt(t1[0]);
        int m1 = Integer.parseInt(t1[1]);
        
        String endTime =  times[1];
        String[] t2 = endTime.split(":");
        int h2 = Integer.parseInt(t2[0]);
        int m2 = Integer.parseInt(t2[1]);
        if( (h2-h1) == 1 && m1 == m2)
        	return true;
        return false;
    }
}
