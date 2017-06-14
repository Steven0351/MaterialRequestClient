package com.stevensherry.httptests;

import com.google.gson.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by steven.sherry on 6/5/2017.
 */
public class TestHTTPFromThirdParty {
  static String oneCard = "https://api.scryfall.com/cards/named?exact=hindering+light&format=json";
  static String moreCards = "https://api.scryfall.com/cards/search?order=cmc&q=t%3Aartifact+pow%3E8+o%3Aflying";

  public static void main(String[] args) {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    HttpGet httpGet = new HttpGet(moreCards);
    TestObject testObject;
    ResponseHandler<JsonObject> rh = new ResponseHandler<JsonObject>() {
      @Override
      public JsonObject handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
        StatusLine statusLine = httpResponse.getStatusLine();
        HttpEntity entity = httpResponse.getEntity();
        if (statusLine.getStatusCode() >= 300) {
          throw new HttpResponseException(
              statusLine.getStatusCode(),
              statusLine.getReasonPhrase());
        }
        if (entity == null) {
          throw new ClientProtocolException("Response contains no content");
        }
        Gson gson = new GsonBuilder().create();
        ContentType contentType = ContentType.getOrDefault(entity);
        Charset charset = contentType.getCharset();
        Reader reader = new InputStreamReader(entity.getContent(), charset);
        return gson.fromJson(reader, JsonObject.class);
      }
    };
    testObject = new TestObject();
    List<TestObject> list = new ArrayList<TestObject>();

    try {
      JsonObject myJson = httpClient.execute(httpGet, rh);
      if (myJson.get("object").getAsString().equals("card")) {
        //         Instantiate single test object
        testObject = new TestObject(myJson.get("id").getAsString(),
            myJson.get("uri").getAsString(),
            myJson.get("multiverse_id").getAsInt(),
            myJson.get("name").getAsString(),
            myJson.get("type_line").getAsString());
      } else if (myJson.get("object").getAsString().equals("list")) {
        // Instantiate JsonArray
        JsonArray jsonArray = myJson.getAsJsonArray("data");

        // Parse JsonArray elements and instantiate into TestObject's to add to list
        for (JsonElement card : jsonArray) {
          JsonObject cardObject = card.getAsJsonObject();
          TestObject loopObject = new TestObject(cardObject.get("id").getAsString(),
              cardObject.get("uri").getAsString(),
              cardObject.get("multiverse_id").getAsInt(),
              cardObject.get("name").getAsString(),
              cardObject.get("type_line").getAsString());
          list.add(loopObject);
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (list.isEmpty()) {
        System.out.println(testObject);
      } else {
        for (TestObject card : list) {
          System.out.println(card);
        }
      }
    }
  }

}


