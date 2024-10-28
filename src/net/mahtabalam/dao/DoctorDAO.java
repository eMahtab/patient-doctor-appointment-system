package net.mahtabalam.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.mahtabalam.entity.Doctor;
import net.mahtabalam.entity.Speciality;

public class DoctorDAO {
    private Map<String, Doctor> doctors = new HashMap<>();

    public Doctor getDoctorByName(String name) {
        return doctors.get(name);
    }

    public void createDoctor(Doctor doctor) {
        doctors.put(doctor.getName(), doctor);
    }

    public List<Doctor> getDoctorsBySpeciality(Speciality speciality) {
        List<Doctor> specialityDoctors = new ArrayList<>();
        for (Doctor doc : doctors.values()) {
            if (doc.getSpeciality().equals(speciality)) {
                specialityDoctors.add(doc);
            }
        }
        return specialityDoctors;
    }
}
