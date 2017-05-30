package com.novokreshchenovleo.test2gis.service.worker;

import com.google.gson.Gson;
import com.novokreshchenovleo.test2gis.model.Profile;
import com.novokreshchenovleo.test2gis.service.Request;

import java.net.URL;
import java.util.concurrent.Callable;

/**
 * Created by xpres on 24/05/17.
 */
public class ProfileWorker extends Request implements Callable {
    private String profileId;

    public ProfileWorker(String profileId, Integer maxAttemptsNumber) {
        this.profileId = profileId;
        this.maxAttemptsNumber = maxAttemptsNumber;
    }

    public Profile call() throws Exception {
        URL url = new URL("http://catalog.api.2gis.ru/profile?key=ruuxah6217&version=1.3&id="+this.profileId);
        String response = super.get(url, maxAttemptsNumber);
        return new Gson().fromJson(response, Profile.class);
    }
}
