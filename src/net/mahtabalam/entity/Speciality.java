package net.mahtabalam.entity;

public enum Speciality {
    CARDIOLOGIST,
    DERMATOLOGIST,
    ORTHOPEDIC,
    GENERAL_PHYSICIAN;
	
	public static Speciality fromString(String speciality) {
        try {
            return Speciality.valueOf(speciality.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid speciality provided");
        }
    }
}