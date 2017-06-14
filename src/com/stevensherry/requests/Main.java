package com.stevensherry.requests;

import java.io.UnsupportedEncodingException;

/**
 * Created by stevensherry on 6/14/17.
 */
public class Main {

  public static void main(String[] args) {
    InventoryItem inventoryItem = new InventoryItem("6U001R101");
    InventoryItem inventoryItem1 = new InventoryItem("6T001R101");
    InventoryItem inventoryItem2 = new InventoryItem("6U008R101");

    inventoryItem.addBinLocations("CAPR010A", "SPRN032");
    inventoryItem1.addBinLocations("SPRS020");
    inventoryItem2.addBinLocations("PAPR020", "QAPR032", "SPRN080");

    CycleCountRequest cycleCountRequest = new CycleCountRequest("requestor");

    try {
      System.out.println(cycleCountRequest.getStringEntity());
    } catch (UnsupportedEncodingException e) {
      System.out.println("Didn't work");
    }

  }

}
