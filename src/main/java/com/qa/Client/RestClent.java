package com.qa.Client;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RestClent {
    public static CloseableHttpResponse GetResponse;

    //1. GET Method without Header

    public CloseableHttpResponse GET_Method(String url) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGetreq = new HttpGet(url);
        GetResponse = httpClient.execute(httpGetreq); //Hit the GET url

        return GetResponse;
    }

    //2. GET Method with Header

    public CloseableHttpResponse GET_Method(String url, HashMap<String, String> HeaderMap) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGetreq = new HttpGet(url);

        for (Map.Entry<String, String> entry : HeaderMap.entrySet()) {
            httpGetreq.addHeader(entry.getKey(), entry.getValue());
        }

        GetResponse = httpClient.execute(httpGetreq); //Hit the GET url

        return GetResponse;
    }

    //3. GET Method with Query Parameter

    public CloseableHttpResponse GET_Method(String url, HashMap<String, String> HeaderMap, String QueryParam) throws IOException {

        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();

            URIBuilder uriBuilder = new URIBuilder(url);
            uriBuilder.setParameter("page", QueryParam);
            //https://reqres.in/api/users?page=2

            HttpGet httpGetreq = new HttpGet(uriBuilder.build());

            for (Map.Entry<String, String> entry : HeaderMap.entrySet()) {
                httpGetreq.addHeader(entry.getKey(), entry.getValue());
            }

            GetResponse = httpClient.execute(httpGetreq); //Hit the GET url


        } catch (Exception e) {
            e.printStackTrace();
        }
        return GetResponse;
    }


    // 4. Post Method
    public CloseableHttpResponse PostMethod(String url, String EntityString, HashMap<String, String> HeaderMap) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url); // Post Request
        httppost.setEntity(new StringEntity(EntityString)); //For Payload

        //For header
        for (Map.Entry<String, String> entry : HeaderMap.entrySet()) {
            httppost.addHeader(entry.getKey(), entry.getValue());
        }

        CloseableHttpResponse httpPOSTresponse = httpClient.execute(httppost);
        return httpPOSTresponse;
    }
}
