package com.stevensherry.httptests;

import com.google.gson.JsonElement;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * Created by stevensherry on 6/20/17.
 */
public class TestHTTPMethodsDELETE {

  static String deleteCreateMaterialRequest = "http://localhost:3005/api/v1/create-material-request/";

  public static void main(String[] args) {


    UserLogin user = new UserLogin("admin", "INfantry030014**", "admin");
    try {
      user.login();
    } catch (IOException e) {
      e.printStackTrace();
    }
    String requestToDelete = deleteCreateMaterialRequest + "593bfbddd7a1bb22df9971cf/" + user.get_id();
    CloseableHttpClient httpClient = HttpClients.createDefault();
    HttpDelete httpDelete = new HttpDelete(requestToDelete);
    httpDelete.addHeader("Content-Type", "application/json");
    httpDelete.addHeader("Authorization", user.getBearerToken());

    try {
      JsonElement myJson = httpClient.execute(httpDelete, TestStatic.makeResponseHandler());
      System.out.println(myJson);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
