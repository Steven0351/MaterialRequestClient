package com.stevensherry.clientclasses;

import java.time.*;

/**
 * Created by steven.sherry on 6/20/2017.
 */
public class PurchaseRequest extends CycleCountRequest {
  private String shippingMethod;
  private boolean hot;
  private boolean dropShip;
  private boolean approved;
  private boolean placed;
  private boolean acknowledgementReceived;
  private String purchaseOrderNumber;
  private String trackingInformation;

  public PurchaseRequest(LocalDateTime dateRequested, String requestor, String shippingMethod, boolean hot, boolean dropShip,
                         boolean approved, boolean placed, boolean acknowledgementReceived, String purchaseOrderNumber,
                         String trackingInformation) {
    super(dateRequested, requestor);
    this.shippingMethod = shippingMethod;
    this.hot = hot;
    this.dropShip = dropShip;
    this.approved = approved;
    this.placed = placed;
    this.acknowledgementReceived = acknowledgementReceived;
    this.purchaseOrderNumber = purchaseOrderNumber;
    this.trackingInformation = trackingInformation;
  }

  public PurchaseRequest(LocalDateTime dateRequested, String requestor, String id, String shippingMethod, boolean hot,
                         boolean dropShip, boolean approved, boolean placed, boolean acknowledgementReceived,
                         String purchaseOrderNumber, String trackingInformation) {
    super(dateRequested, requestor, id);
    this.shippingMethod = shippingMethod;
    this.hot = hot;
    this.dropShip = dropShip;
    this.approved = approved;
    this.placed = placed;
    this.acknowledgementReceived = acknowledgementReceived;
    this.purchaseOrderNumber = purchaseOrderNumber;
    this.trackingInformation = trackingInformation;
  }

  public PurchaseRequest(LocalDateTime dateRequested, String requestor, String shippingMethod, boolean hot, boolean dropShip,
                         boolean approved, boolean placed, boolean acknowledgementReceived, String purchaseOrderNumber,
                         String trackingInformation, String... inventoryItems) {
    super(dateRequested, requestor, inventoryItems);
    this.shippingMethod = shippingMethod;
    this.hot = hot;
    this.dropShip = dropShip;
    this.approved = approved;
    this.placed = placed;
    this.acknowledgementReceived = acknowledgementReceived;
    this.purchaseOrderNumber = purchaseOrderNumber;
    this.trackingInformation = trackingInformation;
  }

  public PurchaseRequest(LocalDateTime dateRequested, String requestor, String id, String shippingMethod, boolean hot,
                         boolean dropShip, boolean approved, boolean placed, boolean acknowledgementReceived,
                         String purchaseOrderNumber, String trackingInformation, String... inventoryItems) {
    super(dateRequested, requestor, id, inventoryItems);
    this.shippingMethod = shippingMethod;
    this.hot = hot;
    this.dropShip = dropShip;
    this.approved = approved;
    this.placed = placed;
    this.acknowledgementReceived = acknowledgementReceived;
    this.purchaseOrderNumber = purchaseOrderNumber;
    this.trackingInformation = trackingInformation;
  }

  public String getShippingMethod() {
    return shippingMethod;
  }

  public void setShippingMethod(String shippingMethod) {
    this.shippingMethod = shippingMethod;
  }

  public boolean isHot() {
    return hot;
  }

  public void setHot(boolean hot) {
    this.hot = hot;
  }

  public boolean isDropShip() {
    return dropShip;
  }

  public void setDropShip(boolean dropShip) {
    this.dropShip = dropShip;
  }

  public boolean isApproved() {
    return approved;
  }

  public void setApproved(boolean approved) {
    this.approved = approved;
  }

  public boolean isPlaced() {
    return placed;
  }

  public void setPlaced(boolean placed) {
    this.placed = placed;
  }

  public boolean isAcknowledgementReceived() {
    return acknowledgementReceived;
  }

  public void setAcknowledgementReceived(boolean acknowledgementReceived) {
    this.acknowledgementReceived = acknowledgementReceived;
  }

  public String getPurchaseOrderNumber() {
    return purchaseOrderNumber;
  }

  public void setPurchaseOrderNumber(String purchaseOrderNumber) {
    this.purchaseOrderNumber = purchaseOrderNumber;
  }

  public String getTrackingInformation() {
    return trackingInformation;
  }

  public void setTrackingInformation(String trackingInformation) {
    this.trackingInformation = trackingInformation;
  }

  public enum PurchaseFilter {
    HOT ("/hot"),
    PLACED ("/placed"),
    REQUESTOR ("/requestor");

    private final String filter;
    PurchaseFilter(String filter) {
      this.filter = filter;
    }

    public String getFilter() {
      return this.filter;
    }

  }

}
