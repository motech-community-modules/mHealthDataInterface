package org.motechproject.mHealthDataInterface.service.impl;

import org.motechproject.mHealthDataInterface.bean.Provider;
import org.motechproject.mHealthDataInterface.config.service.ApplicationSettingsService;
import org.motechproject.mHealthDataInterface.service.HealthWorkerService;
import org.motechproject.mHealthDataInterface.utility.Utility;
import org.motechproject.mHealthDataInterface.utility.mHealthException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class HealthWorkerServiceImpl implements HealthWorkerService {

	ApplicationSettingsService applicationSettingsService;

	@Autowired
	public void setApplicationSettingsService(ApplicationSettingsService applicationSettingsService) {
		this.applicationSettingsService = applicationSettingsService;
	}
	/**
	 *
	 * verify health worker details
	 *
	 */
	@Override
	public boolean verifyHealthWorker(String healthWorkerId) throws mHealthException {



		Utility utility = new Utility(applicationSettingsService.getApplicationSettings());
		if (utility.verifyHealthWorker(healthWorkerId))
			return true;

		return false;
	}


	/**
	 *
	 * get health worker details
	 *
	 */
	@Override
	public Provider getHealthWorkerDetail(String healthWorkerId) throws mHealthException {

		Utility utility = new Utility(applicationSettingsService.getApplicationSettings());
        Provider healthWorker = utility.getHealthWorkerDetail(healthWorkerId);

		return healthWorker;
	}

    /**
     *
     * get health workers details by name
     *
     */
    @Override
    public List<Provider> getHealthWorkersDetailByName(String healthWorkerName) throws mHealthException {
		System.out.println("mHealthDataInterface.openmrs.dbUrl: " + applicationSettingsService.getSettingsValue("mHealthDataInterface.openmrs.dbUrl"));
        Utility utility = new Utility(applicationSettingsService.getApplicationSettings());
        List<Provider> healthWorker = utility.getHealthWorkersDetailByName(healthWorkerName);

        return healthWorker;
    }
	
	

}
