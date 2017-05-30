package com.novokreshchenovleo.test2gis.service.worker;

import com.google.gson.Gson;
import com.novokreshchenovleo.test2gis.model.SearchResult;
import com.novokreshchenovleo.test2gis.service.Request;

import java.net.URL;
import java.util.concurrent.Callable;

/**
 * Created by xpres on 24/05/17.
 */
public class SearchWorker extends Request implements Callable {
    private String category;
    private String cityName;

    public SearchWorker(String category, String cityName, Integer maxAttemptsNumber) {
        this.category = category;
        this.cityName = cityName;
        this.maxAttemptsNumber = maxAttemptsNumber;
    }

    public SearchResult call() throws Exception {
        URL url = new URL("http://catalog.api.2gis.ru/search?version=1.3&key=ruuxah6217&what=" + category + "&where=" + cityName + "&sort=rating");
        String response = super.get(url, maxAttemptsNumber);
        return new Gson().fromJson(response, SearchResult.class);
    }

}
