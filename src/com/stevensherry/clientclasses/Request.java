package com.stevensherry.clientclasses;

import com.stevensherry.httptests.TestStatic;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created by steven.sherry on 6/20/2017.
 */
public abstract class Request implements Comparable {

  private LocalDateTime dateRequested;
  private String requestor;
  private String _id;
  private StringEntity stringEntity;

  protected Request(LocalDateTime dateRequested, String requestor) {
    this.dateRequested = dateRequested;
    this.requestor = requestor;
  }

  protected Request(LocalDateTime dateRequested, String requestor, String id) {
    this(dateRequested, requestor);
    this._id = id;
  }

  public LocalDateTime getDateRequested() {
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

  @Override
  public int compareTo(Object o) {
    if (this == o) {
      return 0;
    } else {
      if (o instanceof Request) {
        if (((Request)o).getDateRequested().compareTo(this.getDateRequested()) > 0) {
          return -1;
        } else if (((Request)o).getDateRequested().compareTo(this.getDateRequested()) == 0) {
          return 0;
        } else {
          return 1;
        }
      }
      System.out.println("Not a Request object!");
      return 1;
    }
  }

  @Override
  public String toString() {
    return requestor + " " + dateRequested.toLocalDate().toString();
  }
}
