package com.stevensherry.requests;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by steven.sherry on 6/8/2017.
 */
public class CycleCountRequest extends BaseRequest {

  private ArrayList<InventoryItem> inventoryItems;

  public CycleCountRequest(String requestor, InventoryItem... inventoryItems) {
    super(requestor);
    this.inventoryItems = new ArrayList<>(Arrays.asList(inventoryItems));
  }

  public CycleCountRequest(String requestor, String dateRequested, String _id, InventoryItem... inventoryItems) {
    super(requestor, dateRequested, _id);
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

}
