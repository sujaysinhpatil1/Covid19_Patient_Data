package com.jbk.patient.dao;

import java.util.List;

import com.jbk.patient.entity.Patient;

public interface PatientDao {
	
	public boolean savePatientInfo(Patient patient);
	
	public Patient getPatientInfo(int patientId);
	
	public boolean deletePatientInfoById(int patientId);

	public List<Patient> getPatientList();
	
	public boolean updatePatientInfo(Patient patient);
			
}
