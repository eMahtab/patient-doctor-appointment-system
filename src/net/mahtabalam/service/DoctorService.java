package net.mahtabalam.service;

import java.util.List;

import net.mahtabalam.dao.DoctorDAO;
import net.mahtabalam.entity.Doctor;
import net.mahtabalam.entity.Speciality;

public class DoctorService {
    private DoctorDAO doctorDAO;
    
    public DoctorService() {
    	doctorDAO = new DoctorDAO();
    }
    
    public Doctor getDoctorByName(String name) {
        return doctorDAO.getDoctorByName(name);
    }
    
    public void registerDoctor(String name, String speciality) {
    	Doctor doctor = new Doctor(name, Speciality.fromString(speciality));
        doctorDAO.createDoctor(doctor);
        System.out.println("Welcome Dr. " + name + "!!");
    }
    
    // Mark Doctor Availability
    public void markDoctorAvailability(String doctorName, String... slots) {
        Doctor doctor = doctorDAO.getDoctorByName(doctorName);
        if (doctor != null) {
            for (String slot : slots) {
            	if(doctor.markAvailability(slot))
            	  System.out.println("Done Doc!");
            }
        } else {
            System.out.println("Doctor not found.");
        }
     }
    
    // Show Available Slots by particular Speciality
    public void showAvailableSlotsBySpeciality(String speciality) {
        List<Doctor> doctors = doctorDAO.getDoctorsBySpeciality(Speciality.fromString(speciality));
        if (doctors != null && !doctors.isEmpty()) {
            for (Doctor doctor : doctors) {
                for (String slot : doctor.getAvailability()) {
                    System.out.println("Dr." + doctor.getName() + ": (" + slot + ")");
                }
            }
        } else {
            System.out.println("No doctors available for this speciality.");
        }
    }
}
