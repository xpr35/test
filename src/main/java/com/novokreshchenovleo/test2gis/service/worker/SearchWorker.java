package com.novokreshchenovleo.test2gis.service.worker;

import com.google.gson.Gson;
import com.novokreshchenovleo.test2gis.model.SearchResult;
import com.novokreshchenovleo.test2gis.service.Request;

import java.util.concurrent.Callable;

/**
 * Created by xpres on 24/05/17.
 */
public class SearchWorker extends Request implements Callable {
    private String category;
    private String cityName;
    private String urlString;
    private String key;
    private String apiVersion;

    public SearchWorker(String category, String cityName, String urlString, String key, String apiVersion) {
        this.category = category;
        this.cityName = cityName;
        this.urlString = urlString;
        this.key = key;
        this.apiVersion = apiVersion;

    }

    public SearchResult call() throws Exception {
        String url = urlString + "?version=" + apiVersion + "&key=" + key + "&what=" + category + "&where=" + cityName + "&sort=rating";
        String response = super.get(url);
        return new Gson().fromJson(response, SearchResult.class);
    }

}
