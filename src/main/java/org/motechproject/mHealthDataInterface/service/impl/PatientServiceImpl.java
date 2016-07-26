package org.motechproject.mHealthDataInterface.service.impl;

import org.motechproject.mHealthDataInterface.bean.Encounter;
import org.motechproject.mHealthDataInterface.bean.Patient;
import org.motechproject.mHealthDataInterface.bean.PatientLocation;
import org.motechproject.mHealthDataInterface.bean.Person.PreferredAddress;
import org.motechproject.mHealthDataInterface.config.service.ApplicationSettingsService;
import org.motechproject.mHealthDataInterface.service.PatientService;
import org.motechproject.mHealthDataInterface.utility.Utility;
import org.motechproject.mHealthDataInterface.utility.mHealthException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PatientServiceImpl implements PatientService {


    ApplicationSettingsService applicationSettingsService;

    @Autowired
    public void setApplicationSettingsService(ApplicationSettingsService applicationSettingsService) {
        this.applicationSettingsService = applicationSettingsService;
    }

    /**
	 * 
	 * get patient details
	 *
	 */
	@Override
	public Patient getPatientDetail(String patientId) throws mHealthException {

		Utility utility = new Utility(applicationSettingsService.getApplicationSettings());
        Patient patient = utility.getPatientDetail(patientId);
		
		return patient;
	}

    /**
     *
     * get patients detail by Name
     *
     */
    @Override
    public List<Patient> getPatientsDetailByName(String patientName) throws mHealthException {

        Utility utility = new Utility(applicationSettingsService.getApplicationSettings());
        List<Patient> patient = utility.getPatientsDetailByName(patientName);

        return patient;
    }

	/**
	 * 
	 * get patients village details
	 *
	 */
	
	@Override
	public PreferredAddress getPatientVillage(String patientId) throws mHealthException {

		Utility utility = new Utility(applicationSettingsService.getApplicationSettings());
        PreferredAddress address = utility.getPatientVillage(patientId);

		return address;
	}
	
	/**
	 * 
	 * get visits details of health workers of a patient
	 *
	 */
	
	@Override
	public List<Encounter> getVisitListByPatientId(String patientId) throws mHealthException {

		Utility utility = new Utility(applicationSettingsService.getApplicationSettings());
		List<Encounter> visits = utility.getVisitListByPatientId(patientId);

		return visits;
	}

    /**
     *
     * get patients living in particular village
     *
     */

    @Override
    public List<PatientLocation> getPatientsByVillage(String village) throws mHealthException {
        System.out.println("mHealthDataInterface.openmrs.dbUrl: " + applicationSettingsService.getSettingsValue("mHealthDataInterface.openmrs.dbUrl"));
        Utility utility = new Utility(applicationSettingsService.getApplicationSettings());
        List<PatientLocation> details = utility.getPatientsByVillage(village);

        return details;
    }

    /**
     *
     * get patients living in particular postal code
     *
     */

    @Override
    public List<PatientLocation> getPatientsByPostalCode(String postalCode) throws mHealthException {

        Utility utility = new Utility(applicationSettingsService.getApplicationSettings());
        List<PatientLocation> details = utility.getPatientsByPostalCode(postalCode);

        return details;
    }

}
