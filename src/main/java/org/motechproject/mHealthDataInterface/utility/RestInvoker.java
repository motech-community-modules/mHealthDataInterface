package org.motechproject.mHealthDataInterface.utility;

import org.apache.commons.codec.binary.Base64;
import org.motechproject.mHealthDataInterface.config.bean.ApplicationSettings;
import org.motechproject.mHealthDataInterface.util.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Custom class for rest client consuming incoming
 */
public class RestInvoker implements Constants {
    private ApplicationSettings applicationSettings;

    public RestInvoker(ApplicationSettings applicationSettings) {
        this.applicationSettings = applicationSettings;
    }

    public String getDataFromServer(String path) {
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(applicationSettings.getBaseUrl() + path);
            URLConnection urlConnection = setUsernamePassword(url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }

    private URLConnection setUsernamePassword(URL url) throws IOException {
        URLConnection urlConnection = url.openConnection();
        String authString = applicationSettings.getUsername() + ":"
                + applicationSettings.getPassword();
        String authStringEnc = new String(Base64.encodeBase64(authString.getBytes()));
        urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
        urlConnection.setRequestProperty("Content-type", "text/xml");
        return urlConnection;
    }
}