package net.mahtabalam.service;

import net.mahtabalam.dao.PatientDAO;
import net.mahtabalam.entity.Patient;

public class PatientService {
	private PatientDAO patientDAO;
	
	public PatientService() {
		patientDAO = new PatientDAO();
	}
	
    // Create and Register a Patient
    public void registerPatient(String name) {
        Patient patient = new Patient(name);
        patientDAO.createPatient(patient);
        System.out.println(name + " registered successfully.");
    }
    
    public Patient getPatientByName(String name) {
        return patientDAO.getPatientByName(name);
    }
    
}
