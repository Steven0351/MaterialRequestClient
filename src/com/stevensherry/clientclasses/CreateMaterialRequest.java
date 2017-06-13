package com.stevensherry.clientclasses;

import com.stevensherry.httptests.TestStatic;
import org.apache.http.entity.StringEntity;

import java.io.IOException;

/**
 * Created by stevensherry on 6/13/17.
 */
public class CreateMaterialRequest {
    private String manufacturerSKU;
    private String description;
    private String requestor;
    private String _id;
    private StringEntity entity;

    public CreateMaterialRequest(String manufacturerSKU, String description, String requestor) {
        this.manufacturerSKU = manufacturerSKU;
        this.description = description;
        this.requestor = requestor;
    }
    public CreateMaterialRequest(String manufacturerSKU, String description, String requestor, String id) {
        this.manufacturerSKU = manufacturerSKU;
        this.description = description;
        this.requestor = requestor;
        this._id = id;
    }

    public void setEntity() {
        try {
            this.entity = new StringEntity(TestStatic.gsonBuilder.toJson(this));
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public String get_id() {
        return _id;
    }

    public StringEntity getEntity() {
        return entity;
    }
}
