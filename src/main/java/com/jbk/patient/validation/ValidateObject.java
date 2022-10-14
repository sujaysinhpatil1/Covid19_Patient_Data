package com.jbk.patient.validation;

import com.jbk.patient.entity.Patient;

public class ValidateObject {

	public static boolean validatePatient(Patient patient) {
		boolean isValid = true;
		if (patient.getPatientName() == null || patient.getPatientName().equals("")) {
			isValid = false;
		}
		if (patient.getpatientScore() <= 0) {
			isValid = false;
		}
		if (patient.getPatientVaccineTaken() <= 0) {
			isValid = false;
		}

		return isValid;

	}
	
}
