package com.stevensherry.clientclasses;

import java.util.ArrayList;

/**
 * Created by steven.sherry on 6/20/2017.
 */
public class InventoryItem {
  private String inventoryID;
  private int quantity;
  private ArrayList<String> binLocations;
  private String cycleCountRequest;
  private String materialIssueRequest;
  private String bomRequest;
  private String purchaseRequest;
  private String adjustmentRequest;
  private String receivingIssue;

  public InventoryItem(String inventoryID, int quantity, Request request) {
    this.inventoryID = inventoryID;
    this.quantity = quantity;
    setRequest(request);
  }

  public InventoryItem(String inventoryID, int quantity, Request request, String... binLocations) {

  }

  private void setRequest(Request request) {
    if (request instanceof AdjustmentRequest) {
      this.adjustmentRequest = request.get_id();
    } else if (request instanceof BomRequest) {
      this.bomRequest = request.get_id();
    } else if (request instanceof MaterialIssueRequest) {
      this.materialIssueRequest = request.get_id();
    } else if (request instanceof PurchaseRequest) {
      this.purchaseRequest = request.get_id();
    } else if (request instanceof ReceivingIssue) {
      this.receivingIssue = request.get_id();
    } else if (request instanceof CycleCountRequest){
      this.cycleCountRequest = request.get_id();
    }
  }

  public String getInventoryID() {
    return inventoryID;
  }

  public int getQuantity() {
    return quantity;
  }

  public ArrayList<String> getBinLocations() {
    return binLocations;
  }

  public String getCycleCountRequest() {
    return cycleCountRequest;
  }

  public String getMaterialIssueRequest() {
    return materialIssueRequest;
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

  public static void main(String[] args) {
    MaterialIssueRequest materialIssueRequest = new MaterialIssueRequest("today","me", "123456","1526");
    CycleCountRequest cycleCountRequest = new CycleCountRequest("today","me","64321");
    InventoryItem inventoryItem = new InventoryItem("15863",10,materialIssueRequest);
    System.out.println(inventoryItem.getMaterialIssueRequest());
    InventoryItem inventoryItem1 = new InventoryItem("25932",20,cycleCountRequest);
    System.out.println(inventoryItem1.getCycleCountRequest());
  }

}



