package org.motechproject.mHealthDataInterface.config.service.impl;


import org.motechproject.mHealthDataInterface.config.bean.ApplicationSettings;
import org.motechproject.mHealthDataInterface.config.service.ApplicationSettingsService;
import org.motechproject.mHealthDataInterface.utility.Utility;
import org.motechproject.server.config.SettingsFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * Implementation of the {@link org.motechproject.mHealthDataInterface.config.service.ApplicationSettingsService} uses {@link org.motechproject.server.config.SettingsFacade}.
 */
@Service("applicationSettingsService")
public class ApplicationSettingsServiceImpl implements ApplicationSettingsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationSettingsServiceImpl.class);
    private static final String CONFIGS_FILE_NAME = "";
    private static final String CONFIGS_PROPERTIES_FILE_NAME = "mHealthDataInterface.properties";

    private SettingsFacade settingsFacade;

    private ApplicationSettings applicationSettings;

    @Autowired
    public ApplicationSettingsServiceImpl(SettingsFacade settingsFacade) {
        this.settingsFacade = settingsFacade;
        loadSettings();
    }

    public ApplicationSettings getApplicationSettings() {
        return applicationSettings;
    }

    @Override
    public String getSettingsValue(String key) {
        if (null == key) {
            return null;
        }
        return settingsFacade.getProperty(key);
    }

    @Override
    public void logInfoWithModuleSettings(String info) {

        LOGGER.info(info + " " +
                getSettingsValue("mHealthDataInterface.openmrs.baseUrl") + " " +
                getSettingsValue("mHealthDataInterface.openmrs.username") + " " +
                getSettingsValue("mHealthDataInterface.openmrs.dbUrl") + " " +
                getSettingsValue("mHealthDataInterface.openmrs.dbDriver") + " " +
                getSettingsValue("mHealthDataInterface.openmrs.dbUsername") + " " +
                getSettingsValue("mHealthDataInterface.openmrs.ERROR_MSG"));
    }

    /**
     *
     */
    private synchronized void loadSettings() {
        logInfoWithModuleSettings("Application Settings:: -- \n");
        applicationSettings = new ApplicationSettings(
                getSettingsValue("mHealthDataInterface.openmrs.baseUrl"),
                getSettingsValue("mHealthDataInterface.openmrs.username"),
                getSettingsValue("mHealthDataInterface.openmrs.password"),
                getSettingsValue("mHealthDataInterface.openmrs.dbUrl"),
                getSettingsValue("mHealthDataInterface.openmrs.dbDriver"),
                getSettingsValue("mHealthDataInterface.openmrs.dbUsername"),
                getSettingsValue("mHealthDataInterface.openmrs.dbPassword"),
                getSettingsValue("mHealthDataInterface.openmrs.ERROR_MSG")
        );

    }

    /**
     * @param settings
     */
    @Override
    public void updateSettings(ApplicationSettings settings) {
//        Gson gson = new Gson();
//        String jsonText = gson.toJson(settings, ApplicationSettings.class);
//        ByteArrayResource resource = new ByteArrayResource(jsonText.getBytes());
//        settingsFacade.saveRawConfig(CONFIGS_FILE_NAME, resource);
        Properties props = new Properties();

        props.setProperty("mHealthDataInterface.openmrs.baseUrl", settings.getBaseUrl());
        props.setProperty("mHealthDataInterface.openmrs.username", settings.getUsername());
        props.setProperty("mHealthDataInterface.openmrs.password", settings.getPassword());
        props.setProperty("mHealthDataInterface.openmrs.dbUrl", settings.getDbUrl());
        props.setProperty("mHealthDataInterface.openmrs.dbDriver", settings.getDbDriver());
        props.setProperty("mHealthDataInterface.openmrs.dbUsername", settings.getDbUsername());
        props.setProperty("mHealthDataInterface.openmrs.dbPassword", settings.getDbPassword());
        props.setProperty("mHealthDataInterface.openmrs.ERROR_MSG", settings.getErrorMessage());

        settingsFacade.saveConfigProperties(CONFIGS_PROPERTIES_FILE_NAME, props);

        loadSettings();
    }
    @Override
    public boolean testDatabaseConnection(ApplicationSettings testSettings) {
        Utility utility = new Utility(testSettings);
        return utility.testDatabaseConnection();
    }
}
