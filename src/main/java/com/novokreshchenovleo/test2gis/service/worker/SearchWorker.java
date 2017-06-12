package com.novokreshchenovleo.test2gis.service.worker;

import com.novokreshchenovleo.test2gis.model.SearchResult;
import com.novokreshchenovleo.test2gis.service.Requester;

public interface SearchWorker {

    void setRequester(Requester requester);
    SearchResult call() throws Exception;
}
