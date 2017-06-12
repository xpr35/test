package com.novokreshchenovleo.test2gis.service.worker.implementation;

import com.google.gson.Gson;
import com.novokreshchenovleo.test2gis.model.Profile;
import com.novokreshchenovleo.test2gis.service.Requester;
import com.novokreshchenovleo.test2gis.service.implementation.RequesterImpl;
import com.novokreshchenovleo.test2gis.service.worker.ProfileWorker;

import java.util.concurrent.Callable;

/**
 * Created by xpres on 24/05/17.
 */
public class ProfileWorkerImpl implements Callable, ProfileWorker {
    private String profileId;
    private String urlString;
    private String key;
    private String apiVersion;
    private Requester requester;

    public ProfileWorkerImpl(String profileId, String urlString, String key, String apiVersion) {
        this.profileId = profileId;
        this.urlString = urlString;
        this.key = key;
        this.apiVersion = apiVersion;
        requester = new RequesterImpl();
    }

    public void setRequester(Requester requester) {
        this.requester = requester;
    }

    public Profile call() throws Exception {
        String url = urlString + "?key=" + key + "&version=" + apiVersion + "&id=" + this.profileId;
        String response = requester.get(url);
        return new Gson().fromJson(response, Profile.class);
    }
}
