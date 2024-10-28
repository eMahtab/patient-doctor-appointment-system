package net.mahtabalam.entity;

public class Appointment {
    private String appointment_id;
    private Doctor doctor;
    private Patient patient;
    private String slot;

    public Appointment(String id, Doctor doctor, Patient patient, String slot) {
        this.appointment_id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.slot = slot;
    }

    public String getAppointmentId() {
        return appointment_id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getSlot() {
        return slot;
    }
}