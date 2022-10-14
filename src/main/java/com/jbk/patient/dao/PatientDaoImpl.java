package com.jbk.patient.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.patient.entity.Patient;

@Repository
public class PatientDaoImpl implements PatientDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean savePatientInfo(Patient patient) {
		Session session = null;
		Transaction transaction = null;
		boolean isAdded = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Patient pnt = session.get(Patient.class, patient.getPatientId());
			if (pnt == null) {
				session.save(patient);
				transaction.commit();
				isAdded = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return isAdded;
	}

	@Override
	public Patient getPatientInfo(int patientId) {
		Session session = null;
		Patient patient = null;
		try {
			session = sessionFactory.openSession();
			patient = session.get(Patient.class, patientId);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return patient;
	}

	@Override
	public List<Patient> getPatientList() {
		List<Patient> list = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Patient.class);
			// criteria.addOrder(Order.asc("ProductId"));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public boolean deletePatientInfoById(int patientId) {
		Session session = null;
		Transaction transaction = null;
		boolean isDeleted = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Patient patient = session.get(Patient.class, patientId);
			if (patient != null) {
				session.delete(patient);
				transaction.commit();
				isDeleted = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isDeleted;
	}

	@Override
	public boolean updatePatientInfo(Patient patient) {
		Session session = null;
		Transaction transaction = null;
		boolean isUpdated = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			int id = (int) patient.getPatientId();
			System.out.println(id);
			Patient pnt = session.get(Patient.class, id);
			if (pnt != null) {
				session.delete(pnt);
				session.save(patient);
				transaction.commit();
				isUpdated = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return isUpdated;
	}


}
