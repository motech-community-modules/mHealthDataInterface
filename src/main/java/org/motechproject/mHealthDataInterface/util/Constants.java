package org.motechproject.mHealthDataInterface.util;


/**
 * Custom class for constants used.
 */
public interface Constants {

    public static final String OPENMRS_BASE_URL_CONFIG_KEY = "mHealthDataInterface.openmrs.baseUrl";
    public static final String OPENMRS_USERNAME_CONFIG_KEY = "mHealthDataInterface.openmrs.username";
    public static final String OPENMRS_PASSWORD_CONFIG_KEY = "mHealthDataInterface.openmrs.password";
    public static final String OPENMRS_DBURL_CONFIG_KEY = "mHealthDataInterface.openmrs.dbUrl";
    public static final String OPENMRS_DBDRIVER_CONFIG_KEY = "mHealthDataInterface.openmrs.dbDriver";
    public static final String OPENMRS_DBUSERNAME_CONFIG_KEY = "mHealthDataInterface.openmrs.dbUsername";
    public static final String OPENMRS_DBPASSWORD_CONFIG_KEY = "mHealthDataInterface.openmrs.dbPassword";
    public static final String ERROR_MSG_CONFIG_KEY = "mHealthDataInterface.openmrs.ERROR_MSG";

    String query_village = "SELECT DISTINCT b.uuid, CONCAT( c.given_name, ' ', c.family_name ) AS name, e.city_village as village, e.address1, e.address2,e.state_province, e.postal_code,e.country, f.value AS phone " +
            "FROM patient a " +
            "INNER JOIN person b ON a.patient_id = b.person_id " +
            "INNER JOIN person_name c ON b.person_id = c.person_id " +
            "INNER JOIN patient_identifier d ON a.patient_id = d.patient_id " +
            "INNER JOIN person_address e ON b.person_id = e.person_id " +
            "INNER JOIN person_attribute f ON b.person_id = f.person_id " +
            "INNER JOIN person_attribute_type pat ON f.person_attribute_type_id = pat.person_attribute_type_id and pat.name='phone' " +
            "WHERE e.city_village like '%";
    String query_postalCode = "SELECT DISTINCT b.uuid, CONCAT( c.given_name, ' ', c.family_name ) AS name, e.city_village as village, e.address1, e.address2,e.state_province, e.postal_code,e.country, f.value AS phone " +
            "FROM patient a " +
            "INNER JOIN person b ON a.patient_id = b.person_id " +
            "INNER JOIN person_name c ON b.person_id = c.person_id " +
            "INNER JOIN patient_identifier d ON a.patient_id = d.patient_id " +
            "INNER JOIN person_address e ON b.person_id = e.person_id " +
            "INNER JOIN person_attribute f ON b.person_id = f.person_id " +
            "INNER JOIN person_attribute_type pat ON f.person_attribute_type_id = pat.person_attribute_type_id and pat.name='phone' " +
            "WHERE e.postal_code ='";

//    String msg = "object not found";

}
