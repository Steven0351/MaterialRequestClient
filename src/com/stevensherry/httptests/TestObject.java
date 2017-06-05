package com.stevensherry.httptests;

/**
 * Created by steven.sherry on 6/5/2017.
 */
public class TestObject {
  private String id;
  private String uri;
  private int multiverseId;
  private String name;
  private String type;

  public TestObject() {
    this.id = "Default";
    this.uri = "Default";
    this.multiverseId = -1;
    this.name = "Default";
    this.type = "Default";
  }

  public TestObject(String id, String uri, int multiverseId, String name, String type) {
    this.id = id;
    this.uri = uri;
    this.multiverseId = multiverseId;
    this.name = name;
    this.type = type;
  }

  public String getId() {
    return id;
  }

  public String getUri() {
    return uri;
  }

  public int getMultiverseId() {
    return multiverseId;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  @Override
  public String toString() {
    return this.name + " of type " + this.type + ". Multiverse id: " + this.multiverseId;
  }
}
