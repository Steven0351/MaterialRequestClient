package com.stevensherry.httptests;

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

    static String loginEndPoint = "http://localhost:3005/api/v1/user/login";
    static String createMaterialRequest = "http://localhost:3005/api/v1/create-material-request/add";
    static String getUserUuidFromServer = "http://localhost:3005/api/v1/user/me";


    public static void main(String[] args) {
        String username = "admin";
        String password = "INfantry030014**";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost login = new HttpPost(loginEndPoint);
        UserLogin user = new UserLogin(username, password);
        Gson gsonBuilder = new GsonBuilder().create();
        try {
            StringEntity postString = new StringEntity(gsonBuilder.toJson(user));
            login.setEntity(postString);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Didn't work");
        }

        login.addHeader("content-type", "application/json");

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

        try {
            JsonObject myJson = httpClient.execute(login, rh);
            if (myJson.get("user").toString() == null) {
                System.out.println("Failed");
            } else {
                user.setToken("Bearer " + myJson.get("token").getAsString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(user.getBearerToken());
        }

        HttpGet getUuid = new HttpGet(getUserUuidFromServer);
        getUuid.addHeader("content-type", "application/json");
        getUuid.addHeader("Authorization", user.getBearerToken());
        try {
            JsonObject myJson = httpClient.execute(getUuid, rh);
            user.setUuid(myJson.get("id").getAsString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        HttpPost createMaterial = new HttpPost(createMaterialRequest);
        createMaterial.addHeader("content-type", "application/json");
        createMaterial.addHeader("Authorization", user.getBearerToken());
        CreateMaterialRequest createMaterialRequest = new CreateMaterialRequest("W7001K101", "rebateable TONABLE FIBER", user.getUuid());
        try {
            StringEntity postString = new StringEntity(gsonBuilder.toJson(createMaterialRequest));
            System.out.println(gsonBuilder.toJson(createMaterialRequest));
            createMaterial.setEntity(postString);
            JsonObject myJson = httpClient.execute(createMaterial, rh);
            System.out.println(myJson);
        } catch (IOException e) {
            e.printStackTrace();

        }


    }
}

class UserLogin {
    private String username;
    private String password;
    private String bearerToken;
    private String uuid;

    UserLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    void setToken(String tokenFromServer) {
        this.bearerToken = tokenFromServer;
    }

    void setUuid(String uuidFromServer) {
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
}

class CreateMaterialRequest {
    private String manufacturerSKU;
    private String description;
    private String requestor;

    public CreateMaterialRequest(String manufacturerSKU, String description, String requestor) {
        this.manufacturerSKU = manufacturerSKU;
        this.description = description;
        this.requestor = requestor;
    }

    public String getManufacturerSKU() {
        return manufacturerSKU;
    }

    public String getDescription() {
        return description;
    }

    public String getRequestor() {
        return requestor;
    }
}
