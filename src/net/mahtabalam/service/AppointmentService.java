package net.mahtabalam.service;

import java.util.UUID;

import net.mahtabalam.dao.AppointmentDAO;
import net.mahtabalam.entity.Appointment;
import net.mahtabalam.entity.Doctor;
import net.mahtabalam.entity.Patient;

public class AppointmentService {
    private DoctorService doctorService;
    private PatientService patientService;
    private AppointmentDAO appointmentDAO;
    
    public AppointmentService(DoctorService doctorService, PatientService patientService) {
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.appointmentDAO = new AppointmentDAO();
    }
   
    // Book Appointment
    public Appointment bookAppointment(String patientName, String doctorName, String timeSlot) {
        Patient patient = patientService.getPatientByName(patientName);
        Doctor doctor = doctorService.getDoctorByName(doctorName);
        Appointment appointment = null;
        if (patient == null || doctor == null) {
            System.out.println("Invalid doctor or patient.");
            return null;
        }
        
        // Check if the time slot is available
        if (doctor.getAvailability().contains(timeSlot)) {
            String bookingId = UUID.randomUUID().toString();
            appointment = new Appointment(bookingId, doctor, patient, timeSlot);
            doctor.removeAvailability(timeSlot);  // Remove slot from doctor's availability
            patient.addAppointment(appointment);  // Add appointment to patient
            appointmentDAO.saveAppointment(appointment);  // Store appointment by ID
            System.out.println("Booked. Booking id: " + bookingId);
        } else {
            System.out.println("Slot not available.");
        }
        return appointment;
    }
    
    // Cancel Appointment by Booking ID
    public void cancelAppointment(String bookingId) {
        Appointment appointment = appointmentDAO.findAppointmentById(bookingId);
        if (appointment != null) {
            Doctor doctor = appointment.getDoctor();
            Patient patient = appointment.getPatient();
            doctor.markAvailability(appointment.getSlot());  // Make slot available again
            patient.removeAppointment(appointment);  // Remove from patient's list
            appointmentDAO.deleteAppointment(bookingId);  // Remove from appointments
            System.out.println("Booking Cancelled");
        } else {
            System.out.println("Invalid booking ID.");
        }
    }
    
    // Show Appointments for Patient
    public void showAppointmentsBooked(String patientName) {
        Patient patient = patientService.getPatientByName(patientName);
        if (patient != null) {
            for (Appointment appointment : patient.getBookedAppointments()) {
                System.out.println("Booking id: " + appointment.getAppointmentId() + ", Dr " +
                         appointment.getDoctor().getName() + " " + appointment.getSlot());
            }
        } else {
            System.out.println("No patient found with that name.");
        }
    }
    
}