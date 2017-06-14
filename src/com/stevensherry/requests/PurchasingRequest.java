package com.stevensherry.requests;

/**
 * Created by stevensherry on 6/13/17.
 */
public class PurchasingRequest extends CycleCountRequest {
  private String shippingMethod;
  private boolean isHot;
  private boolean isDropShip;
  private boolean orderHasBeenApproved;
  private boolean orderHasBeenPlaced;
  private boolean orderAcknowledgementReceived;
  private String purchaseOrderNumber;
  private String vendor;
  private String trackingInformation;

  public PurchasingRequest(String requestor, String shippingMethod, boolean isHot,
                           boolean isDropShip, boolean orderHasBeenApproved, boolean orderHasBeenPlaced,
                           boolean orderAcknowledgementReceived, String purchaseOrderNumber, String vendor,
                           String trackingInformation, InventoryItem... inventoryItems) {

    super(requestor, inventoryItems);
    this.shippingMethod = shippingMethod;
    this.isHot = isHot;
    this.isDropShip = isDropShip;
    this.orderHasBeenApproved = orderHasBeenApproved;
    this.orderHasBeenPlaced = orderHasBeenPlaced;
    this.orderAcknowledgementReceived = orderAcknowledgementReceived;
    this.purchaseOrderNumber = purchaseOrderNumber;
    this.vendor = vendor;
    this.trackingInformation = trackingInformation;
  }

  public PurchasingRequest(String requestor, String dateRequested, String _id, String shippingMethod,
                           boolean isHot, boolean isDropShip, boolean orderHasBeenApproved,
                           boolean orderHasBeenPlaced, boolean orderAcknowledgementReceived,
                           String purchaseOrderNumber, String vendor, String trackingInformation,
                           InventoryItem... inventoryItems) {

    super(requestor, dateRequested, _id, inventoryItems);
    this.shippingMethod = shippingMethod;
    this.isHot = isHot;
    this.isDropShip = isDropShip;
    this.orderHasBeenApproved = orderHasBeenApproved;
    this.orderHasBeenPlaced = orderHasBeenPlaced;
    this.orderAcknowledgementReceived = orderAcknowledgementReceived;
    this.purchaseOrderNumber = purchaseOrderNumber;
    this.vendor = vendor;
    this.trackingInformation = trackingInformation;
  }

  public String getShippingMethod() {
    return shippingMethod;
  }

  public boolean isHot() {
    return isHot;
  }

  public boolean isDropShip() {
    return isDropShip;
  }

  public boolean isOrderHasBeenApproved() {
    return orderHasBeenApproved;
  }

  public boolean isOrderHasBeenPlaced() {
    return orderHasBeenPlaced;
  }

  public boolean isOrderAcknowledgementReceived() {
    return orderAcknowledgementReceived;
  }

  public String getPurchaseOrderNumber() {
    return purchaseOrderNumber;
  }

  public String getVendor() {
    return vendor;
  }

  public String getTrackingInformation() {
    return trackingInformation;
  }

  public void setShippingMethod(String shippingMethod) {
    this.shippingMethod = shippingMethod;
  }

  public void setHot(boolean hot) {
    isHot = hot;
  }

  public void setDropShip(boolean dropShip) {
    isDropShip = dropShip;
  }

  public void setOrderHasBeenApproved(boolean orderHasBeenApproved) {
    this.orderHasBeenApproved = orderHasBeenApproved;
  }

  public void setOrderHasBeenPlaced(boolean orderHasBeenPlaced) {
    this.orderHasBeenPlaced = orderHasBeenPlaced;
  }

  public void setOrderAcknowledgementReceived(boolean orderAcknowledgementReceived) {
    this.orderAcknowledgementReceived = orderAcknowledgementReceived;
  }

  public void setPurchaseOrderNumber(String purchaseOrderNumber) {
    this.purchaseOrderNumber = purchaseOrderNumber;
  }

  public void setVendor(String vendor) {
    this.vendor = vendor;
  }

  public void setTrackingInformation(String trackingInformation) {
    this.trackingInformation = trackingInformation;
  }

}
