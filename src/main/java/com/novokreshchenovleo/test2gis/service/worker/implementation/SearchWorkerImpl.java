package com.novokreshchenovleo.test2gis.service.worker.implementation;

import com.google.gson.Gson;
import com.novokreshchenovleo.test2gis.model.SearchResult;
import com.novokreshchenovleo.test2gis.service.Requester;
import com.novokreshchenovleo.test2gis.service.implementation.RequesterImpl;
import com.novokreshchenovleo.test2gis.service.worker.SearchWorker;

import java.util.concurrent.Callable;

/**
 * Created by xpres on 24/05/17.
 */
public class SearchWorkerImpl implements Callable, SearchWorker {
    private String category;
    private String cityName;
    private String urlString;
    private String key;
    private String apiVersion;
    private Requester requester;

    public SearchWorkerImpl(String category, String cityName, String urlString, String key, String apiVersion) {
        this.category = category;
        this.cityName = cityName;
        this.urlString = urlString;
        this.key = key;
        this.apiVersion = apiVersion;
        requester = new RequesterImpl();
    }

    public void setRequester(Requester requester) {
        this.requester = requester;
    }

    public SearchResult call() throws Exception {
        String url = urlString + "?version=" + apiVersion + "&key=" + key + "&what=" + category + "&where=" + cityName + "&sort=rating";
        String response = requester.get(url);
        return new Gson().fromJson(response, SearchResult.class);
    }

}
