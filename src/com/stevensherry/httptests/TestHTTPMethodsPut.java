package com.stevensherry.httptests;

import com.google.gson.JsonElement;
import com.stevensherry.clientclasses.CreateMaterialRequest;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * Created by stevensherry on 6/13/17.
 */
public class TestHTTPMethodsPut {
    static String putCreateMaterialRequest = "http://localhost:3005/api/v1/create-material-request/";

    public static void main(String[] args) {
        String requestToEdit = putCreateMaterialRequest + "593bfbddd7a1bb22df9971cf";
        UserLogin user = new UserLogin("admin", "INfantry030014**");
        try {
            user.login();
        } catch (IOException e) {
            e.printStackTrace();
        }

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut(requestToEdit);
        httpPut.addHeader("content-type", "application/json");
        httpPut.addHeader("Authorization", user.getBearerToken());
        CreateMaterialRequest createMaterialRequest = new CreateMaterialRequest("6U008R101", "8 Fiber Dielectric Flat Drop Cable", user.getUuid());


        try {
            StringEntity putEntity = new StringEntity(TestStatic.gsonBuilder.toJson(createMaterialRequest));
            System.out.println(TestStatic.gsonBuilder.toJson(createMaterialRequest));
            httpPut.setEntity(putEntity);
            JsonElement myJson = httpClient.execute(httpPut, TestStatic.makeResponseHandler());
            System.out.println(myJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
