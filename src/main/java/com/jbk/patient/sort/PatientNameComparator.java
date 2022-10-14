package com.jbk.patient.sort;

import java.util.Comparator;

import com.jbk.patient.entity.Patient;

public class PatientNameComparator implements Comparator<Patient>{

	@Override
	public int compare(Patient p1, Patient p2) {
		
		return p1.getPatientName().compareTo(p2.getPatientName());
	}

}
