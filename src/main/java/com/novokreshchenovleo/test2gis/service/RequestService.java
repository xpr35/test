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
    private Integer maxAttemptNumber;

    public RequestService(Integer threadNumber, Integer maxAttemptNumber) {
        this.executorService = Executors.newFixedThreadPool(threadNumber);
        this.maxAttemptNumber = maxAttemptNumber;
    }

    public Future<SearchResult> getSearchResult(String category, String cityName) {
        return executorService.submit(new SearchWorker(category, cityName, maxAttemptNumber));
    }

    public Future<Profile> getProfile(String profileId) {
        return executorService.submit(new ProfileWorker(profileId, maxAttemptNumber));
    }
}
