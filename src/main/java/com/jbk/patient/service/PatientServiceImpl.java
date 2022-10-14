package com.jbk.patient.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.patient.dao.PatientDao;
import com.jbk.patient.entity.Patient;
import com.jbk.patient.sort.PatientNameComparator;
import com.jbk.patient.sort.PatientScoreComparator;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDao dao;

	@Override
	public boolean savePatientInfo(Patient patient) {
		boolean isAdded = dao.savePatientInfo(patient);
		return isAdded;
	}

	@Override
	public Patient getPatientInfo(int patientId) {
		Patient patient = dao.getPatientInfo(patientId);
		return patient;
	}

	@Override
	public List<Patient> getPatientList() {
		List<Patient> list = dao.getPatientList();
		return list;
	}

	@Override
	public boolean deletePatientInfoById(int patientId) {
		boolean isDeleted = dao.deletePatientInfoById(patientId);
		return isDeleted;
	}

	@Override
	public boolean updatePatientInfo(Patient patient) {
		boolean isDeleted = dao.updatePatientInfo(patient);
		return isDeleted;
	}

	@Override
	public boolean checkIfListIsEmpty(List<Patient> list) {
		if (!list.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Patient> sortPatients(String sortBy) {
		List<Patient> list = getPatientList();

		if (list.size() > 1) {
			if (sortBy.equalsIgnoreCase("patientScore")) {
				Collections.sort(list, new PatientScoreComparator());
			} else if (sortBy.equalsIgnoreCase("patientName")) {
				Collections.sort(list, new PatientNameComparator());
			}
		}
		return list;
	}

}
