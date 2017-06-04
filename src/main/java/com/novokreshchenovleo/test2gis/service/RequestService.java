package com.novokreshchenovleo.test2gis.service;

import com.novokreshchenovleo.test2gis.model.Profile;
import com.novokreshchenovleo.test2gis.model.SearchResult;
import com.novokreshchenovleo.test2gis.service.worker.ProfileWorker;
import com.novokreshchenovleo.test2gis.service.worker.SearchWorker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by xpres on 26/05/17.
 */
public class RequestService {
    private ExecutorService executorService;
    private String apiVersion;
    private String key;

    public RequestService(Integer threadNumber, String key, String apiVersion) {
        this.executorService = Executors.newFixedThreadPool(threadNumber);
        this.key = key;
        this.apiVersion = apiVersion;
    }

    public Future<SearchResult> getSearchResult(String category, String cityName, String url) {
        return executorService.submit(new SearchWorker(category, cityName, url, key, apiVersion));
    }

    public Future<Profile> getProfile(String profileId, String url) {
        return executorService.submit(new ProfileWorker(profileId, url, key, apiVersion));
    }
}
