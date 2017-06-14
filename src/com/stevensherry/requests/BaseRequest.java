package com.stevensherry.requests;

import com.google.gson.JsonElement;
import com.stevensherry.httptests.TestStatic;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by stevensherry on 6/13/17.
 */
abstract class BaseRequest {

  private String requestor;
  private String dateRequested;
  private String _id;

  public BaseRequest(String requestor) {
    this.requestor = requestor;
  }

  public BaseRequest(String requestor, String dateRequested, String _id) {
    this(requestor);
    this.dateRequested = dateRequested;
    this._id = _id;
  }

  public String getRequestor() {
    return requestor;
  }

  public String getDateRequested() {
    return dateRequested;
  }

  public String get_id() {
    return _id;
  }

  public StringEntity getStringEntity() throws UnsupportedEncodingException {
    System.out.println(TestStatic.gsonBuilder.toJson(this));
    return new StringEntity(TestStatic.gsonBuilder.toJson(this));
  }

}
