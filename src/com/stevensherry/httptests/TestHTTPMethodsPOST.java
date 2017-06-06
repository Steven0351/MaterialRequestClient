package com.stevensherry.httptests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.stevensherry.User;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
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

static String loginEndPoint = "http://localhost:3005/api/v1/user/login";


    public static void main(String[] args) {
        String username = "admin";
        String password = "INfantry030014**";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(loginEndPoint);
        UserLogin user = new UserLogin(username,password);
        Gson gsonBuilder = new GsonBuilder().create();
        try {
            StringEntity postString = new StringEntity(gsonBuilder.toJson(user));
            httpPost.setEntity(postString);
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("Didn't work");
        }
        httpPost.addHeader("content-type", "application/json");

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

        try {
            JsonObject myJson = httpClient.execute(httpPost, rh);
            if(myJson.get("user").toString() == null) {
                System.out.println("Failed");
            } else {
                System.out.println(myJson.get("token"));
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }



}

class UserLogin {
    private String username;
    private String password;

    public UserLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }
}