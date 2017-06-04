package com.novokreshchenovleo.test2gis.service;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.apache.http.HttpHeaders.USER_AGENT;

/**
 * Created by xpres on 29/05/17.
 */
public class Request {
    private static final Logger log = LogManager.getLogger(Request.class);

    public String get(String url) throws Exception {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        request.addHeader("User-Agent", USER_AGENT);
        HttpResponse response = client.execute(request);

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        return result.toString();
    }
}
