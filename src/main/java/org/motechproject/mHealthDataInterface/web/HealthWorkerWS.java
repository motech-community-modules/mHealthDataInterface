package org.motechproject.mHealthDataInterface.web;

import com.google.gson.Gson;
import org.motechproject.mHealthDataInterface.bean.Provider;
import org.motechproject.mHealthDataInterface.config.service.ApplicationSettingsService;
import org.motechproject.mHealthDataInterface.service.HealthWorkerService;
import org.motechproject.mHealthDataInterface.util.Constants;
import org.motechproject.mHealthDataInterface.utility.mHealthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class HealthWorkerWS {
    ApplicationSettingsService applicationSettingsService;
    private HealthWorkerService healthWorkerService;

    public void setHealthWorkerService(HealthWorkerService healthWorkerService) {

        this.healthWorkerService = healthWorkerService;
    }

    @Autowired
    public void setApplicationSettingsService(ApplicationSettingsService applicationSettingsService) {
        this.applicationSettingsService = applicationSettingsService;
    }
    /**
	 * 
	 * verify healthworker details
	 *
	 */
    
    @RequestMapping(value = "/verifyHealthWorker/{healthWorkerId}", produces = "application/json")
	public @ResponseBody String verifyHealthWorker(@PathVariable String healthWorkerId) {

       	Gson gson = new Gson();
        String json = null;
        String msg = null;

    	try {
            if (healthWorkerService != null && healthWorkerId != null && healthWorkerId.length() > 0) {

                if (healthWorkerService.verifyHealthWorker(healthWorkerId)) {
                   msg = "valid health worker";
                } else {
                    msg = "invalid health worker";
                }

            } else {
                msg = applicationSettingsService.getSettingsValue(Constants.ERROR_MSG_CONFIG_KEY);;
                json = gson.toJson(msg);

                return json;
            }

    	} catch (mHealthException e) {
    		msg = applicationSettingsService.getSettingsValue(Constants.ERROR_MSG_CONFIG_KEY);;
    	}

        json = gson.toJson(msg);
        return json;
	}
    

    /**
	 * 
	 * get health worker details
	 *
	 */

    @RequestMapping(value = "/healthWorkerDetail/{healthWorkerId}", produces = "application/json")
	public @ResponseBody String getHealthWorkerDetail(@PathVariable String healthWorkerId) {
        Gson gson = new Gson();

        String json = null;
        String returnVal = null;
        Provider healthworker = null;
        String msg = null;

        try {

            if (healthWorkerService != null && healthWorkerId != null && healthWorkerId.length() > 0) {
                healthworker = healthWorkerService.getHealthWorkerDetail(healthWorkerId);
            }

            if (healthworker != null){
                json = gson.toJson(healthworker);

                returnVal = json;
            } else {
                msg = applicationSettingsService.getSettingsValue(Constants.ERROR_MSG_CONFIG_KEY);
                json = gson.toJson(msg);

                returnVal = json;
            }
        } catch(mHealthException e) {
            msg = applicationSettingsService.getSettingsValue(Constants.ERROR_MSG_CONFIG_KEY);
            json = gson.toJson(msg);
            returnVal = json;
        }
         return returnVal;
	}

    /**
     *
     * get health workers detail by name
     *
     */

    @RequestMapping(value = "/healthWorkersDetailByName/{healthWorkerName}", produces = "application/json")
    public @ResponseBody String getHealthWorkersDetailByName(@PathVariable String healthWorkerName) {
        Gson gson = new Gson();

        String json = null;
        String returnVal = null;
        List<Provider> healthworker = null;
        String msg = null;

        try {

            if (healthWorkerService != null && healthWorkerName != null && healthWorkerName.length() > 0) {
                healthworker = healthWorkerService.getHealthWorkersDetailByName(healthWorkerName);
            }

            if (healthworker != null){
                json = gson.toJson(healthworker);

                returnVal = json;
            } else {
                msg = applicationSettingsService.getSettingsValue(Constants.ERROR_MSG_CONFIG_KEY);
                json = gson.toJson(msg);

                returnVal = json;
            }
        } catch(mHealthException e) {
            msg = applicationSettingsService.getSettingsValue(Constants.ERROR_MSG_CONFIG_KEY);;
            json = gson.toJson(msg);
            returnVal = json;
        }
        return returnVal;
    }

}