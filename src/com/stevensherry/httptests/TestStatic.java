package com.stevensherry.httptests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;


/**
 * Created by stevensherry on 6/13/17.
 */
public class TestStatic {

  public static Gson gsonBuilder = new GsonBuilder().create();

  public static ResponseHandler<JsonElement> makeResponseHandler() {
    ResponseHandler<JsonElement> rh = new ResponseHandler<JsonElement>() {
      @Override
      public JsonElement handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
        StatusLine statusLine = httpResponse.getStatusLine();
        HttpEntity entity = httpResponse.getEntity();
        if (statusLine.getStatusCode() >= 300 && statusLine.getStatusCode() != 500 && statusLine.getStatusCode() != 403) {
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
        return gson.fromJson(reader, JsonElement.class);
      }
    };
    return rh;
  }
}
