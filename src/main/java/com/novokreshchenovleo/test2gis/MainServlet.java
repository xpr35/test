package com.novokreshchenovleo.test2gis;


import com.google.gson.Gson;
import com.novokreshchenovleo.test2gis.model.Place;
import com.novokreshchenovleo.test2gis.model.Profile;
import com.novokreshchenovleo.test2gis.model.SearchResult;
import com.novokreshchenovleo.test2gis.service.RequestService;
import com.novokreshchenovleo.test2gis.util.Configuration;
import com.novokreshchenovleo.test2gis.util.ConfigurationManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;

/**
 * Created by xpres on 23/05/17.
 */

public class MainServlet extends HttpServlet {

    private static final Logger log = LogManager.getLogger(MainServlet.class);
    private static final Configuration conf = ConfigurationManager.getConfiguration("/tmp/config.yml");

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(conf.getContent());

        PrintWriter printWriter = resp.getWriter();
        String category = req.getParameter("category");
        if (category == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "category parameter is required");
            log.warn("category parameter wasn't in request");
            return;
        }

        RequestService requestService = new RequestService(conf.getThreads(), conf.getKey(), conf.getVersion());

        ArrayList<String> cities = new ArrayList<String>(Arrays.asList(conf.getCities()));
        List<Place> places = new CopyOnWriteArrayList<Place>();


        ArrayList<Future<SearchResult>> futureArrayList = new ArrayList<Future<SearchResult>>();
        for (String city : cities) {
            futureArrayList.add(requestService.getSearchResult(category, city, conf.getSearch()));
        }

        ArrayList<Future<Profile>> futures = new ArrayList<Future<Profile>>();
        for (Future<SearchResult> result : futureArrayList) {
            try {
                SearchResult.Result[] searchResults = result.get().getResults();
                if (searchResults != null) {
                    futures.add(requestService.getProfile(searchResults[0].getId(), conf.getProfile()));
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }

        for (Future<Profile> futureProfile : futures) {
            try {
                Profile profile = futureProfile.get();
                places.add(new Place(profile.getName(), profile.getCityName(), profile.getAddress(), profile.getRating()));
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }

        Collections.sort(places);
        printWriter.print(new Gson().toJson(places));
    }
}
