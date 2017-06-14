package com.stevensherry.httptests;

import com.google.gson.JsonElement;
import com.stevensherry.clientclasses.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/**
 * Created by stevensherry on 6/6/17.
 */
public class TestHTTPMethodsPOST {

  static String createMaterialRequest = "http://localhost:3005/api/v1/create-material-request/add";

  public static void main(String[] args) {


    CloseableHttpClient httpClient = HttpClients.createDefault();
    Gson gsonBuilder = new GsonBuilder().create();

    UserLogin user = new UserLogin("admin", "INfantry030014**", "admin");
    try {
      user.login();
    } catch (IOException e) {
      e.printStackTrace();
    }

    HttpPost createMaterial = new HttpPost(createMaterialRequest);
    createMaterial.addHeader("content-type", "application/json");
    createMaterial.addHeader("Authorization", user.getBearerToken());
    CreateMaterialRequest createMaterialRequest = new CreateMaterialRequest("1F.SM.LC.LC.3FT", "3FT Singlemode LC to LC jumper", user.getUuid());
    try {
      StringEntity postString = new StringEntity(gsonBuilder.toJson(createMaterialRequest));
      System.out.println(gsonBuilder.toJson(createMaterialRequest));
      createMaterial.setEntity(postString);
      JsonElement myJson = httpClient.execute(createMaterial, TestStatic.makeResponseHandler());
      System.out.println(myJson);
    } catch (IOException e) {
      e.printStackTrace();

    }
  }
}

