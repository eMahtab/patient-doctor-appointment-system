package net.mahtabalam.driver;

import net.mahtabalam.entity.Appointment;
import net.mahtabalam.service.AppointmentService;
import net.mahtabalam.service.DoctorService;
import net.mahtabalam.service.PatientService;

public class App {
    public static void main(String[] args) { 
    	
        DoctorService doctorService = new DoctorService();
        // Register doctor
        doctorService.registerDoctor("Curious", "Cardiologist");
        doctorService.markDoctorAvailability("Curious", "9:00-10:30");
        doctorService.markDoctorAvailability("Curious", "9:00-10:00", "12:00-13:00", "16:00-17:00");
        
        doctorService.registerDoctor("Dreadful", "Dermatologist");
        // Mark availability
        doctorService.markDoctorAvailability("Dreadful", "9:00-10:00", "11:00-12:00", "13:00-14:00");
        
        // Show available slots by speciality
        doctorService.showAvailableSlotsBySpeciality("Cardiologist");
        
        PatientService patientService = new PatientService();
        // Register patient
        patientService.registerPatient("PatientA");
        
        // Initialize AppointmentService
        AppointmentService appointmentService = new AppointmentService(doctorService, patientService);
        
        // Book appointment
        Appointment patientAppointment= appointmentService.bookAppointment("PatientA", "Curious", "12:00-13:00");
       
        // Show available slots by speciality
        doctorService.showAvailableSlotsBySpeciality("Cardiologist");
        
        // Cancel booking
        appointmentService.cancelAppointment(patientAppointment.getAppointmentId());  // Pass actual booking ID from previous step
        
        // Show booked appointments
        appointmentService.showAppointmentsBooked("PatientA");
    }
}
