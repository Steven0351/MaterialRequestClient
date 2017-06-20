package com.stevensherry.clientclasses;

import com.stevensherry.httptests.TestStatic;
import org.apache.http.entity.StringEntity;

import java.io.IOException;

/**
 * Created by steven.sherry on 6/20/2017.
 */
public abstract class Request {

  private String dateRequested;
  private String requestor;
  private String _id;
  private StringEntity stringEntity;

  public Request(String dateRequested, String requestor) {
    this.dateRequested = dateRequested;
    this.requestor = requestor;
  }

  public Request(String dateRequested, String requestor, String id) {
    this(dateRequested, requestor);
    this._id = id;
  }

  public String getDateRequested() {
    return dateRequested;
  }

  public String getRequestor() {
    return requestor;
  }

  public String get_id() {
    return _id;
  }

  public StringEntity getStringEntity() {
    this.setEntity();
    return stringEntity;
  }

  private void setEntity() {
    try {
      this.stringEntity = new StringEntity(TestStatic.gsonBuilder.toJson(this));
      System.out.println(TestStatic.gsonBuilder.toJson(this));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
