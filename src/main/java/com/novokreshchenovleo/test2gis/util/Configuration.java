package com.novokreshchenovleo.test2gis.util;

import java.util.Arrays;

/**
 * Created by xpres on 04/06/17.
 */
public class Configuration {
    public String getSearch() {
        return search;
    }

    public String getProfile() {
        return profile;
    }

    public String getKey() {
        return key;
    }

    public int getThreads() {
        return threads;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }

    public String[] getCities() {
        return cities;
    }

    public void setCities(String[] cities) {
        this.cities = cities;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getContent() { return content; }

    public void setContent(String content) {
        this.content = content;
    }

    private String search;
    private String profile;
    private String key;
    private int threads;
    private String version;
    private String[] cities;
    private String content;

    @Override
    public String toString() {
        return "Configuration{" +
                "search='" + search + '\'' +
                ", profile='" + profile + '\'' +
                ", key='" + key + '\'' +
                ", threads=" + threads +
                ", version='" + version + '\'' +
                ", cities=" + Arrays.toString(cities) +
                ", content='" + content + '\'' +
                '}';
    }
}
