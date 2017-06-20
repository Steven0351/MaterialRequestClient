package com.stevensherry.clientclasses;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by steven.sherry on 6/20/2017.
 */
public class InventoryItem {
  private String inventoryID;
  private int quantity;
  private ArrayList<String> binLocations;
  private String _id;
  private String cycleCountRequest;
  private String materialIssueRequest;
  private String bomRequest;
  private String purchaseRequest;
  private String adjustmentRequest;
  private String receivingIssue;

  public InventoryItem(String inventoryID, int quantity, Request request) {
    this.inventoryID = inventoryID;
    this.quantity = quantity;
    this.setRequest(request);
    this.binLocations = new ArrayList<>();
  }

  public InventoryItem(String inventoryID, int quantity, Request request, String... binLocations) {
    this(inventoryID, quantity, request);
    this.binLocations = new ArrayList<>(Arrays.asList(binLocations));
  }

  public InventoryItem(String inventoryID, int quantity,  Request request, String _id, String... binLocations) {
    this(inventoryID, quantity, request, binLocations);
    this._id = _id;
  }

  public InventoryItem(String inventoryID, int quantity, Request request, String _id) {
    this(inventoryID, quantity, request);
    this._id = _id;
  }

  private void setRequest(Request request) {
    switch(request.getClass().getName()) {
      case "com.stevensherry.clientclasses.PurchaseRequest":
        this.purchaseRequest = request.get_id();
        break;
      case "com.stevensherry.clientclasses.AdjustmentRequest":
        this.adjustmentRequest = request.get_id();
        break;
      case "com.stevensherry.clientclasses.CycleCountRequest":
        this.cycleCountRequest = request.get_id();
        break;
      case "com.stevensherry.clientclasses.BomRequest":
        this.bomRequest = request.get_id();
        break;
      case "com.stevensherry.clientclasses.MaterialIssueRequest":
        this.materialIssueRequest = request.get_id();
        break;
      case "com.stevensherry.clientclasses.ReceivingIssue":
        this.receivingIssue = request.get_id();
        break;
    }
  }

  public String getInventoryID() {
    return inventoryID;
  }

  public int getQuantity() {
    return quantity;
  }

  public ArrayList<String> getBinLocations() {
    return new ArrayList<>(this.binLocations);
  }

  public void addBinLocation(String binLocation) {
    this.binLocations.add(binLocation);
  }

  public void addBinLocation(String... binLocations) {
    this.binLocations.addAll(Arrays.asList(binLocations));
  }

  public String getCycleCountRequest() {
    return cycleCountRequest;
  }

  public String getMaterialIssueRequest() {
    return materialIssueRequest;
  }

  public String get_id() {
    return this._id;
  }

  public String getBomRequest() {
    return bomRequest;
  }

  public String getPurchaseRequest() {
    return purchaseRequest;
  }

  public String getAdjustmentRequest() {
    return adjustmentRequest;
  }

  public String getReceivingIssue() {
    return receivingIssue;
  }

}



