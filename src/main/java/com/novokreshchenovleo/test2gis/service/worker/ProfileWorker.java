package com.novokreshchenovleo.test2gis.service.worker;

import com.novokreshchenovleo.test2gis.model.Profile;
import com.novokreshchenovleo.test2gis.service.Requester;

public interface ProfileWorker {
    void setRequester(Requester requester);
    Profile call() throws Exception;
}