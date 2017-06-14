package com.stevensherry.requests;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by steven.sherry on 6/9/2017.
 */
public class InventoryItem {

  private String inventoryID;
  private String quantity;
  private ArrayList<String> binLocations;
  private String cycleCountRequest;
  private String materialIssueRequest;
  private String bomRequest;
  private String purchaseRequest;
  private String adjustmentRequest;
  private String receivingIssue;

  public InventoryItem(String inventoryID) {
    this.inventoryID = inventoryID;
    this.binLocations = new ArrayList<>();
  }

  public String getInventoryID() {
    return inventoryID;
  }

  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    if(quantity >= 0) {
      this.quantity = Integer.toString(quantity);
    }
  }

  public void addBinLocations(String... binLocations) {
    this.binLocations.addAll(Arrays.asList(binLocations));
  }

  public ArrayList<String> getBinLocations() {
    return new ArrayList<>(this.binLocations);
  }

  public boolean removeBinLocation(String binLocation) {
    return this.binLocations.remove(binLocation);
  }

  public String getCycleCountRequest() {
    return cycleCountRequest;
  }

  public void setCycleCountRequest(String cycleCountRequest) {
    this.cycleCountRequest = cycleCountRequest;
  }

  public String getMaterialIssueRequest() {
    return materialIssueRequest;
  }

  public void setMaterialIssueRequest(String materialIssueRequest) {
    this.materialIssueRequest = materialIssueRequest;
  }

  public String getBomRequest() {
    return bomRequest;
  }

  public void setBomRequest(String bomRequest) {
    this.bomRequest = bomRequest;
  }

  public String getPurchaseRequest() {
    return purchaseRequest;
  }

  public void setPurchaseRequest(String purchaseRequest) {
    this.purchaseRequest = purchaseRequest;
  }

  public String getAdjustmentRequest() {
    return adjustmentRequest;
  }

  public void setAdjustmentRequest(String adjustmentRequest) {
    this.adjustmentRequest = adjustmentRequest;
  }

  public String getReceivingIssue() {
    return receivingIssue;
  }

  public void setReceivingIssue(String receivingIssue) {
    this.receivingIssue = receivingIssue;
  }
}
