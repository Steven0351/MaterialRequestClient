package com.stevensherry.clientclasses;

import java.time.*;

/**
 * Created by steven.sherry on 6/20/2017.
 */
public class ReceivingIssue extends CycleCountRequest {

  private String vendor;
  private String purchaseOrder;
  private String descriptionOfIssue;

  public ReceivingIssue(LocalDateTime dateRequested, String requestor, String vendor, String purchaseOrder, String descriptionOfIssue) {
    super(dateRequested, requestor);
    this.vendor = vendor;
    this.purchaseOrder = purchaseOrder;
    this.descriptionOfIssue = descriptionOfIssue;
  }

  public ReceivingIssue(LocalDateTime dateRequested, String requestor, String id, String vendor, String purchaseOrder, String descriptionOfIssue) {
    super(dateRequested, requestor, id);
    this.vendor = vendor;
    this.purchaseOrder = purchaseOrder;
    this.descriptionOfIssue = descriptionOfIssue;
  }

  public ReceivingIssue(LocalDateTime dateRequested, String requestor, String vendor, String purchaseOrder, String descriptionOfIssue, String... inventoryItems) {
    super(dateRequested, requestor, inventoryItems);
    this.vendor = vendor;
    this.purchaseOrder = purchaseOrder;
    this.descriptionOfIssue = descriptionOfIssue;
  }

  public ReceivingIssue(LocalDateTime dateRequested, String requestor, String id, String vendor, String purchaseOrder, String descriptionOfIssue, String... inventoryItems) {
    super(dateRequested, requestor, id, inventoryItems);
    this.vendor = vendor;
    this.purchaseOrder = purchaseOrder;
    this.descriptionOfIssue = descriptionOfIssue;
  }

  public String getVendor() {
    return vendor;
  }

  public void setVendor(String vendor) {
    this.vendor = vendor;
  }

  public String getPurchaseOrder() {
    return purchaseOrder;
  }

  public void setPurchaseOrder(String purchaseOrder) {
    this.purchaseOrder = purchaseOrder;
  }

  public String getDescriptionOfIssue() {
    return descriptionOfIssue;
  }

  public void setDescriptionOfIssue(String descriptionOfIssue) {
    this.descriptionOfIssue = descriptionOfIssue;
  }
}
