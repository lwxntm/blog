package com.github.lwxntm.blog.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author xiaotian
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IpSbResponse {

    @JsonProperty("city")
    public String city;
    @JsonProperty("country")
    private String country;
    @JsonProperty("offset")
    private int offset;
    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("isp")
    private String isp;

    @JsonProperty("ip")
    private String ip;

    @JsonProperty("latitude")
    private double latitude;

    @JsonProperty("continent_code")
    private String continentCode;

    @JsonProperty("asn_organization")
    private String asnOrganization;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("organization")
    private String organization;

    @JsonProperty("region")
    private String region;

    @JsonProperty("asn")
    private int asn;

    @JsonProperty("longitude")
    private double longitude;

    @JsonProperty("region_code")
    private String regionCode;

    public String getCountry() {
        return country;
    }

    public int getOffset() {
        return offset;
    }

    public String getCity() {
        return city;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getIsp() {
        return isp;
    }

    public String getIp() {
        return ip;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getContinentCode() {
        return continentCode;
    }

    public String getAsnOrganization() {
        return asnOrganization;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getOrganization() {
        return organization;
    }

    public String getRegion() {
        return region;
    }

    public int getAsn() {
        return asn;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getRegionCode() {
        return regionCode;
    }
}