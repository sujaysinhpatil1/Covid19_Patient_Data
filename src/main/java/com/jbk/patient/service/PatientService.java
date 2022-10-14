package com.jbk.patient.service;

import java.util.List;

import com.jbk.patient.entity.Patient;

public interface PatientService {
	
	public boolean savePatientInfo(Patient patient);
	
	public Patient getPatientInfo(int patientId);
	
	public boolean deletePatientInfoById(int patientId);

	public List<Patient> getPatientList();
	
	public boolean updatePatientInfo(Patient patient);

	public List<Patient> sortPatients(String sortBy);

	public boolean checkIfListIsEmpty(List<Patient> list);

}
