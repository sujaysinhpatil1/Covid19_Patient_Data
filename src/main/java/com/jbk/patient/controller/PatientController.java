package com.jbk.patient.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.patient.entity.Patient;
import com.jbk.patient.exception.ProductNotFoundException;
import com.jbk.patient.service.PatientService;

@RestController
public class PatientController {

	@Autowired
	private PatientService service;

	@PostMapping(value = "/savePatientInfo")//boolean
	public ResponseEntity<Boolean> savePatientInfo(@Valid @RequestBody Patient patient) {
		boolean isAdded = service.savePatientInfo(patient);
		if (isAdded) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping(value = "/getPatientInfo/{patientId}")
	public ResponseEntity<Patient> getPatientInfo(@PathVariable int patientId) {
		Patient patient = service.getPatientInfo(patientId);
		if (patient!=null) {
			return new ResponseEntity<Patient>(patient, HttpStatus.OK);
		} else {
			throw new ProductNotFoundException("Patient not found with id : "+ patientId);
		}

	}
	
	@GetMapping(value = "/getPatientList")
	public ResponseEntity<List<Patient>> getPatientList() {
		List<Patient> list = service.getPatientList();
		if (list!=null) {
			return new ResponseEntity<List<Patient>>(list, HttpStatus.OK);
		} else {
			throw new ProductNotFoundException("Patients not found");
		}

	}
	
	@GetMapping(value = "/deletePatientInfoById")
	public ResponseEntity<Boolean> deletePatientInfoById(@RequestParam int patientId) {
		boolean isDeleted = service.deletePatientInfoById(patientId);
		if (isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		} else {
			throw new ProductNotFoundException("Patient not found with id : "+ patientId);
		}

	}
	
	@PutMapping(value = "/updatePatientInfo")
	public ResponseEntity<Boolean> updatePatientInfo(@Valid @RequestBody Patient patient) {
		boolean isAdded = service.updatePatientInfo(patient);
		if (isAdded) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.OK);
		} else {
			throw new ProductNotFoundException("Patient not found with id : "+ patient.getPatientId());
		}

	}
	
	@GetMapping(value = "/sortPatients/{sortBy}")
	public ResponseEntity<List<Patient>> sortPatients(@PathVariable String sortBy) {//@RequestParam
		List<Patient> list = service.sortPatients(sortBy);

		if (service.checkIfListIsEmpty(list)) {
			return new ResponseEntity<List<Patient>>(list, HttpStatus.OK);
		} else {
			throw new ProductNotFoundException("Patients not found");
		}
	}


}
