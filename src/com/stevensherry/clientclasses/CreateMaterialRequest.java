package com.stevensherry.clientclasses;

import com.google.gson.stream.JsonWriter;
import com.stevensherry.httptests.TestStatic;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by stevensherry on 6/13/17.
 */
public class CreateMaterialRequest {
  private String manufacturerSKU;
  private String description;
  private String requestor;
  private String id;
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
    this.id = id;
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

  public String getId() {
    return id;
  }

  public void writeJsonStream(OutputStream out, CreateMaterialRequest request) throws IOException {
    JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
    writer.setIndent("  ");
    writeCreateMaterialRequestObject(writer, request);
    writer.close();
  }

  public void writeCreateMaterialRequestObject(JsonWriter writer, CreateMaterialRequest materialRequest) throws
      IOException {
    writer.beginObject();
    if(materialRequest.id != null) {
      writer.name("id").value(materialRequest.getId());
    }
  }

}
