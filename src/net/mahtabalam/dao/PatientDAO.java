package net.mahtabalam.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.mahtabalam.entity.Patient;

public class PatientDAO {
    private Map<String, Patient> patients = new HashMap<>();
    
    public List<Patient> getPatients() {
    	List<Patient> allPatients =  new ArrayList<>();
    	allPatients.addAll(patients.values());
    	return allPatients;
    }

    public Patient getPatientByName(String name) {
        return patients.get(name);
    }

    public void createPatient(Patient patient) {
        patients.put(patient.getName(), patient);
    }
}