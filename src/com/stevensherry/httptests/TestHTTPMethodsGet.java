package com.stevensherry.httptests;

import com.google.gson.JsonElement;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * Created by stevensherry on 6/13/17.
 */
public class TestHTTPMethodsGet {
    static String getCreateMaterialRequests = "http://localhost:3005/api/v1/create-material-request/";
    public static void main(String[] args) {
        UserLogin user = new UserLogin("admin", "INfantry030014**");
        try {
            user.login();
        } catch (IOException e) {
            e.printStackTrace();
        }

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(getCreateMaterialRequests);
        httpGet.addHeader("content-type", "application/json");
        httpGet.addHeader("Authorization", user.getBearerToken());
        try {
            JsonElement myJson = httpClient.execute(httpGet, TestStatic.makeResponseHandler());
            System.out.println(myJson);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
