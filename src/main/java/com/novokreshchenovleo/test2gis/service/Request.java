package com.novokreshchenovleo.test2gis.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by xpres on 29/05/17.
 */
public class Request {
    private static final Logger log = LogManager.getLogger(Request.class);
    protected Integer maxAttemptsNumber;

    public String get(URL obj, Integer maxAttemptsNumber) throws Exception {
        synchronized (RequestService.class) {
            int attempts = 0;
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            StringBuffer response = new StringBuffer();
            int responseCode = con.getResponseCode();

            while (responseCode != 200 && attempts < maxAttemptsNumber) {
                attempts++;
                log.warn("Trying to make a request. Attempt #" + attempts);
                con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");
                responseCode = con.getResponseCode();
            }

            if (responseCode != 200) {
                log.error("Couldn't get response");
                throw new Exception();
            }

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        }
    }
}
