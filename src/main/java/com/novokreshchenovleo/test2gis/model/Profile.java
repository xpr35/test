package com.novokreshchenovleo.test2gis.model;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by xpres on 25/05/17.
 */
public class Profile implements Serializable {
    @SerializedName("api_version")
    private String apiVersion;

    @SerializedName("response_code")
    private String response_code;

    private String id;
    private String lon;
    private String lat;

    @SerializedName("booklet_url")
    private String booklet_url;

    @SerializedName("booklet_title")
    private String bookletTitle;

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    private String name;

    private Firm firm;

    public class Firm {
        private String id;
        @SerializedName("filials_count")
        private Integer filialsCount;

        @Override
        public String toString() {
            return "Firm{" +
                    "id='" + id + '\'' +
                    ", filialsCount=" + filialsCount +
                    '}';
        }
    }

    @SerializedName("register_bc_url")
    private String registerBcUrl;

    @SerializedName("project_id")
    private String project_id;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) { this.cityName = cityName; }

    @SerializedName("city_name")
    private String cityName;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) { this.address = address; }

    private String address;


    @SerializedName("additional_info")
    private AdditionalInfo additionalInfo;
    public class AdditionalInfo{
        private String office;
        private Boolean wifi;
        @SerializedName("business_lunch")
        private Boolean businessLunch;
        @SerializedName("avg_price")
        private Integer avgPrice;
        private String currency;
    }

    private String article;

    @SerializedName("fas_warning")
    private String fasWarning;

    @SerializedName("fas_warning_micro_comment")
    private String fasWarningMicroFormat;

    private Link link;
    public class Link {
        private String link;
        private String text;

        public String getLink() { return link; }
        public String getText() { return text; }

        @Override
        public String toString() {
            return "Link{" +
                    "link='" + link + '\'' +
                    ", text='" + text + '\'' +
                    '}';
        }
    }

    private Contact[] contacts;
    public class Contact {
        private String name;
        private ContactInternal[] contacts;
        public class ContactInternal {
            private String type;
            private String value;
            @SerializedName("email_regster_bc_url")
            private String emailRegisterBcUrl;
            @SerializedName("phone_register_bc_url")
            private String phoneRegisterBcUrl;
            private String alias;
            private String comment;

            @Override
            public String toString() {
                return "ContactInternal{" +
                        "type='" + type + '\'' +
                        ", value='" + value + '\'' +
                        ", emailRegisterBcUrl='" + emailRegisterBcUrl + '\'' +
                        ", phoneRegisterBcUrl='" + phoneRegisterBcUrl + '\'' +
                        ", alias='" + alias + '\'' +
                        ", comment='" + comment + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "Contact{" +
                    "name='" + name + '\'' +
                    ", contacts=" + Arrays.toString(contacts) +
                    '}';
        }
    }

    private Map<String, JsonElement> schedule; //ToDo FIX IT
    public class WorkingTime {
        private Map<String, WorkingHours> workingTime;
        public class WorkingHours {
            private String from;
            private String to;
        }
    }

    private String[] payoptions;

    private String[] rubrics;

    public void setRating(Float rating) { this.rating = rating; }

    private Float rating;

    @SerializedName("reviews_count")
    private Integer reviewsCount;

    @SerializedName("see_also")
    private Filials seeAlso;
    public class Filials {
        private String id;
        private String lon;
        private String lat;
        private String name;
        private String hash;
        @SerializedName("city_name")
        private String cityName;
        private String address;
        private Advertisement ads;
    }
    public class Advertisement {
        @SerializedName("sponsored_article")
        private SponsoredArticle sponsoredArticle;
        public class SponsoredArticle {
            private String title;
            private String text;
        }
        private String warning;
        @SerializedName("warning_micro_comment")
        private String warningMicroComment;

        @SerializedName("warning_article")
        private String warning_article;
    }

    @SerializedName("employees_org_count")
    private String employeesOrgCount;

    public Float getRating() {
        return rating;
    }
}
