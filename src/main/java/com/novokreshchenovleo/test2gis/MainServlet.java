package com.novokreshchenovleo.test2gis;


import com.google.gson.Gson;
import com.novokreshchenovleo.test2gis.model.Place;
import com.novokreshchenovleo.test2gis.model.Profile;
import com.novokreshchenovleo.test2gis.model.SearchResult;
import com.novokreshchenovleo.test2gis.service.RequestService;
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
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by xpres on 23/05/17.
 */

public class MainServlet extends HttpServlet {

    private static final Logger log = LogManager.getLogger(MainServlet.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=koi8-r");
        PrintWriter printWriter = resp.getWriter();

        String category = req.getParameter("category");
        if (category == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "category parameter is required");
            log.warn("category parameter wasn't in request");
            return;
        }

        RequestService requestService = new RequestService(10, 5);

        ArrayList<String> cities = new ArrayList<String>(Arrays.asList("Новосибирск", "Омск", "Томск", "Кемерово", "Новокузнецк"));
        List<Place> places = new CopyOnWriteArrayList<Place>();


        ArrayList<Future<SearchResult>> futureArrayList = new ArrayList<Future<SearchResult>>();
        for (String city : cities) {
            futureArrayList.add(requestService.getSearchResult(category, city));
        }

        ArrayList<Future<Profile>> futures = new ArrayList<Future<Profile>>();
        for (Future<SearchResult> result : futureArrayList) {
            try {
                SearchResult searchResult = result.get();
                if (searchResult.getResults() != null) {
                    futures.add(requestService.getProfile(searchResult.getResults()[0].getId()));
                }
            } catch (ExecutionException e) {
                log.error(e.getMessage());

            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }

        for (Future<Profile> futureProfile : futures) {
            try {
                Profile profile = futureProfile.get();
                places.add(new Place(profile.getName(), profile.getCityName(), profile.getAddress(), profile.getRating()));
            } catch (ExecutionException e) {
                log.error(e.getMessage());

            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }

        Collections.sort(places);
        printWriter.print(new Gson().toJson(places));
    }
}
