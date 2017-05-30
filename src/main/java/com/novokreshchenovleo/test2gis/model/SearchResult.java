package com.novokreshchenovleo.test2gis.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Arrays;

public class SearchResult implements Serializable {

    @SerializedName("api_version")
    private String apiVersion;

    @SerializedName("response_code")
    private String responseCode;

    private String what;
    private String where;
    private Integer total;

    @SerializedName("did_you_mean")
    private DidYouMean didYouMean;
    private Advert[] advertising;

    @SerializedName("result")
    private Result[] results;

    public class Rubrics {
        private String name;

        public String getRubrics() { return name; }

        @Override
        public String toString() {
            return "Rubrics{" +
                    "rubrics='" + name + '\'' +
                    '}';
        }
    }


    public class DidYouMean {
        private Rubrics[] rubrics;
        private Geo[] geo;

        private class Geo {
            private String name;
            private String keyword;

            public String getName() { return name; }
            public String getKeyword() { return keyword; }

            @Override
            public String toString() {
                return "Geo{" +
                        "name='" + name + '\'' +
                        ", keyword='" + keyword + '\'' +
                        '}';
            }
        }

        public Rubrics[] getRubrics() { return rubrics; }
        public Geo[] getGeo() { return geo; }

        @Override
        public String toString() {
            return "DidYouMean{" +
                    "rubrics=" + Arrays.toString(rubrics) +
                    ", geo=" + Arrays.toString(geo) +
                    '}';
        }
    }

    public class Advert {

        @SerializedName("firm_id")
        private String firmId;
        private String hash;
        private String title;
        private String text;

        @SerializedName("fas_warning")
        private String fasWarning;

        @SerializedName("fas_warning_micro_comment")
        private String fasWarningMicroComment;
        private String lon;
        private String lat;
        private String type;

        public String getFirmId() { return firmId; }
        public String getHash() { return hash; }
        public String getTitle() { return title; }
        public String getText() { return text; }
        public String getFasWarning() { return fasWarning; }
        public String getFasWarningMicroComment() { return fasWarningMicroComment; }
        public String getLon() { return lon; }
        public String getLat() { return lat; }
        public String getType() { return type; }

        @Override
        public String toString() {
            return "Advert{" +
                    "firmId='" + firmId + '\'' +
                    ", hash='" + hash + '\'' +
                    ", title='" + title + '\'' +
                    ", text='" + text + '\'' +
                    ", fasWarning='" + fasWarning + '\'' +
                    ", fasWarningMicroComment='" + fasWarningMicroComment + '\'' +
                    ", lon='" + lon + '\'' +
                    ", lat='" + lat + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }
    }

    public class Result {
        private String id;
        private String lon;
        private String lat;
        private String name;

        @SerializedName("firm_group")
        private FirmGroup firmGroup;

        private class FirmGroup {
            private String id;
            private String count;

            public String getId() { return id; }
            public String getCount() { return count; }

            @Override
            public String toString() {
                return "FirmGroup{" +
                        "id='" + id + '\'' +
                        ", count='" + count + '\'' +
                        '}';
            }
        }

        private Integer dist;
        private String hash;
        @SerializedName("city_name")
        private String cityName;
        private String address;
        private String[] rubrics;

        @SerializedName("reviews_count")
        private Integer reviewsCount;

        @SerializedName("micro_comment")
        private String microComment;

        @SerializedName("fas_warning")
        private String fasWarning;

        @SerializedName("fas_warning_article")
        private String fasWarningArticle;

        public String getId() {
            return id;
        }

        public String getLon() {
            return lon;
        }

        public String getLat() {
            return lat;
        }

        public String getName() {
            return name;
        }

        public FirmGroup getFirmGroup() {
            return firmGroup;
        }

        public Integer getDist() {
            return dist;
        }

        public String getHash() {
            return hash;
        }

        public String getCityName() {
            return cityName;
        }

        public String getAddress() {
            return address;
        }

        public String[] getRubrics() {
            return rubrics;
        }

        public Integer getReviewsCount() {
            return reviewsCount;
        }

        public String getMicroComment() {
            return microComment;
        }

        public String getFasWarning() {
            return fasWarning;
        }

        public String getFasWarningArticle() {
            return fasWarningArticle;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "id='" + id + '\'' +
                    ", lon='" + lon + '\'' +
                    ", lat='" + lat + '\'' +
                    ", name='" + name + '\'' +
                    ", firmGroup=" + firmGroup +
                    ", dist=" + dist +
                    ", hash='" + hash + '\'' +
                    ", cityName='" + cityName + '\'' +
                    ", address='" + address + '\'' +
                    ", rubrics=" + Arrays.toString(rubrics) +
                    ", reviewsCount=" + reviewsCount +
                    ", microComment='" + microComment + '\'' +
                    ", fasWarning='" + fasWarning + '\'' +
                    ", fasWarningArticle='" + fasWarningArticle + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "apiVersion='" + apiVersion + '\'' +
                ", responseCode='" + responseCode + '\'' +
                ", what='" + what + '\'' +
                ", where='" + where + '\'' +
                ", total=" + total +
                ", didYouMean=" + didYouMean +
                ", advertising=" + Arrays.toString(advertising) +
                ", results=" + Arrays.toString(results) +
                '}';
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public String getWhat() {
        return what;
    }

    public String getWhere() {
        return where;
    }

    public Integer getTotal() {
        return total;
    }

    public DidYouMean getDidYouMean() {
        return didYouMean;
    }

    public Advert[] getAdvertising() {
        return advertising;
    }

    public Result[] getResults() {
        return results;
    }
}
