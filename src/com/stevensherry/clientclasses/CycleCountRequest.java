package com.stevensherry.clientclasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.time.*;

/**
 * Created by steven.sherry on 6/20/2017.
 */
public class CycleCountRequest extends Request {

  private ArrayList<String> inventoryItems;

  public CycleCountRequest(LocalDateTime dateRequested, String requestor) {
    super(dateRequested, requestor);
    this.inventoryItems = new ArrayList<>();
  }

  public CycleCountRequest(LocalDateTime dateRequested, String requestor, String id) {
    super(dateRequested, requestor, id);
    this.inventoryItems = new ArrayList<>();
  }

  public CycleCountRequest(LocalDateTime dateRequested, String requestor, String... inventoryItems) {
    this(dateRequested, requestor);
    this.inventoryItems = new ArrayList<>(Arrays.asList(inventoryItems));
  }

  public CycleCountRequest(LocalDateTime dateRequested, String requestor, String id, String... inventoryItems) {
    this(dateRequested, requestor, id);
    this.inventoryItems = new ArrayList<>(Arrays.asList(inventoryItems));
  }

  public ArrayList<String> getInventoryItems() {
    return new ArrayList<>(inventoryItems);
  }

  public void addInventoryItem(String inventoryItem) {
    this.inventoryItems.add(inventoryItem);
  }

  public void addInventoryItem(String... inventoryItems) {
    this.inventoryItems.addAll(Arrays.asList(inventoryItems));
  }

}
