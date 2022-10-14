package com.jbk.patient.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Patient {
	
	@Id
	private int patientId;
	
	@NotNull(message = "PatientName is required")
	private String patientName;
	
	private String patientStateName;
	private String patientCityName;
	
	@Min(0)
	private Integer patientVaccineTaken;
	
	private double patientAddmitedDate;
	
	@Min(0)
	private Integer patientScore;
	
	public Patient() {
		// TODO Auto-generated constructor stub
	}

	public Patient(int patientId, String patientName, String patientStateName, String patientCityName, int patientVaccineTaken,
			double patientAddmitedDate, int patientScore) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientStateName = patientStateName;
		this.patientCityName = patientCityName;
		this.patientVaccineTaken = patientVaccineTaken;
		this.patientAddmitedDate = patientAddmitedDate;
		this.patientScore = patientScore;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientStateName() {
		return patientStateName;
	}

	public void setPatientStateName(String patientStateName) {
		this.patientStateName = patientStateName;
	}

	public String getPatientCityName() {
		return patientCityName;
	}

	public void setPatientCityName(String patientCityName) {
		this.patientCityName = patientCityName;
	}

	public Integer getPatientVaccineTaken() {
		return patientVaccineTaken;
	}

	public void setPatientVaccineTaken(Integer patientVaccineTaken) {
		this.patientVaccineTaken = patientVaccineTaken;
	}

	public double getPatientAddmitedDate() {
		return patientAddmitedDate;
	}

	public void setPatientAddmitedDate(double patientAddmitedDate) {
		this.patientAddmitedDate = patientAddmitedDate;
	}

	public Integer getpatientScore() {
		return patientScore;
	}

	public void setpatientScore(Integer patientScore) {
		this.patientScore = patientScore;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientStateName="
				+ patientStateName + ", patientCityName=" + patientCityName + ", patientVaccineTaken="
				+ patientVaccineTaken + ", patientAddmitedDate=" + patientAddmitedDate + ", patientScore="
				+ patientScore + "]";
	}

}
