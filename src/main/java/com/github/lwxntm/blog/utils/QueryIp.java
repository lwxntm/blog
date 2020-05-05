package com.github.lwxntm.blog.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.lwxntm.blog.pojo.IpSbResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Objects;

/**
 * @author xiaotian
 */
public class QueryIp {
    public static OkHttpClient client = new OkHttpClient();
    static ObjectMapper mapper = new ObjectMapper();

    public static String httpGet(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return Objects.requireNonNull(response.body()).string();
        }
    }


    public static String getIpInfo(String ip) {

        try {
            String resp = httpGet("https://api.ip.sb/geoip/" + ip);
            IpSbResponse ipsbResponse = mapper.readValue(resp, IpSbResponse.class);
            if (ipsbResponse.getCity() == null) {
                ipsbResponse.city = "=> ";
            }
            return ipsbResponse.getIp() + "\nAS " + ipsbResponse.getAsn() + " " + ipsbResponse.getAsnOrganization() + " \n " +
                    ipsbResponse.city + " " + ipsbResponse.getCountry() + " " + ipsbResponse.getCountryCode();

        } catch (IOException e) {
            return e.toString();
        }
    }

    public static String handleRawStrThenGetIpInfo(String str) {
        String s = str;
        System.out.println(s);
        if (s.startsWith("http://")) {
            System.out.println(true);
            s = s.substring(7);
        }
        if (s.startsWith("https://")) {
            System.out.println(true);
            s = s.substring(8);
        }
        if (s.contains("/")) {
            System.out.println(true);
            s = s.substring(0, s.indexOf("/"));
        }
        if (s.contains(":")) {
            System.out.println(true);
            s = s.substring(0, s.indexOf(":"));
        }
        try {
            String hostAddress = InetAddress.getByName(s).getHostAddress();
            return getIpInfo(hostAddress);
        } catch (IOException e) {
            return e.toString();
        }
    }
}