package com.stevensherry.httptests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
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
 * Created by stevensherry on 6/11/17.
 */
public class UserLogin {

  private String username;
  private String password;
  private String bearerToken;
  private String role;
  private String uuid;
  static String getUserUuidFromServer = "http://localhost:3005/api/v1/user/me";
  static String loginEndPoint = "http://localhost:3005/api/v1/user/login";
  private HttpPost login;
  private HttpGet uuidGet;

  UserLogin(String username, String password, String role) {
    this.username = username;
    this.password = password;
    this.role = role;
    this.login = new HttpPost(loginEndPoint);
    this.login.addHeader("content-type", "application/json");
    this.uuidGet = new HttpGet(getUserUuidFromServer);
    this.uuidGet.addHeader("content-type", "application/json");
  }

  public void login() throws IOException {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    ResponseHandler<JsonObject> rh = new ResponseHandler<JsonObject>() {
      @Override
      public JsonObject handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
        StatusLine statusLine = httpResponse.getStatusLine();
        HttpEntity entity = httpResponse.getEntity();
        if (statusLine.getStatusCode() >= 300 && statusLine.getStatusCode() != 500) {
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
    Gson gsonBuilder = new Gson();
    StringEntity loginEntity = new StringEntity(gsonBuilder.toJson(this));
    this.login.setEntity(loginEntity);
    JsonObject myJson = httpClient.execute(this.login, rh);
    this.setToken("Bearer " + myJson.get("token").getAsString());
    this.uuidGet.addHeader("Authorization", this.getBearerToken());
    myJson = httpClient.execute(this.uuidGet, rh);
    this.setUuid(myJson.get("id").getAsString());
  }

  public void setToken(String tokenFromServer) {
    this.bearerToken = tokenFromServer;
  }

  public void setUuid(String uuidFromServer) {
    this.uuid = uuidFromServer;
  }

  public String getUsername() {
    return username;
  }

  public String getBearerToken() {
    return bearerToken;
  }

  public String getUuid() {
    return uuid;
  }

  @Override
  public String toString() {
    return "UserLogin{" +
        "username='" + username + '\'' +
        ", bearerToken='" + bearerToken + '\'' +
        ", uuid='" + uuid + '\'' +
        '}';
  }
}
