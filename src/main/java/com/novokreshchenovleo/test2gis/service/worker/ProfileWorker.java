package com.novokreshchenovleo.test2gis.service.worker;

import com.google.gson.Gson;
import com.novokreshchenovleo.test2gis.model.Profile;
import com.novokreshchenovleo.test2gis.service.Request;

import java.util.concurrent.Callable;

/**
 * Created by xpres on 24/05/17.
 */
public class ProfileWorker extends Request implements Callable {
    private String profileId;
    private String urlString;
    private String key;
    private String apiVersion;

    public ProfileWorker(String profileId, String urlString, String key, String apiVersion) {
        this.profileId = profileId;
        this.urlString = urlString;
        this.key = key;
        this.apiVersion = apiVersion;
    }

    public Profile call() throws Exception {
        String url = urlString + "?key=" + key + "&version=" + apiVersion + "&id=" + this.profileId;
        String response = super.get(url);
        return new Gson().fromJson(response, Profile.class);
    }
}
