package com.stevensherry.Classes;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by steven.sherry on 6/8/2017.
 */
abstract class BaseRequest {

  private ArrayList<InventoryItem> inventoryItems;
  private String requestor;
  private String dateRequested;

  public BaseRequest(String requestor, String dateRequested) {
    this.requestor = requestor;
    this.dateRequested = dateRequested;
    this.inventoryItems = new ArrayList<>();
  }

  public BaseRequest(String requestor, String dateRequested, InventoryItem... inventoryItems) {
    this.requestor = requestor;
    this.dateRequested = dateRequested;
    this.inventoryItems = new ArrayList<>(Arrays.asList(inventoryItems));
  }

  public ArrayList<InventoryItem> getInventoryItems() {
    return new ArrayList<>(this.inventoryItems);
  }

  public void addInventoryItem(InventoryItem inventoryItem) {
    this.inventoryItems.add(inventoryItem);
  }

  public boolean removeInventoryItem(InventoryItem inventoryItem) {
    return this.inventoryItems.remove(inventoryItem);
  }

  public String getRequestor() {
    return requestor;
  }

  public String getDateRequested() {
    return dateRequested;
  }

}
