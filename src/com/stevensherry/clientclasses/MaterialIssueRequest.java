package com.stevensherry.clientclasses;

import java.time.*;

/**
 * Created by steven.sherry on 6/20/2017.
 */
public class MaterialIssueRequest extends CycleCountRequest{

  private String workOrder;

  public MaterialIssueRequest(LocalDateTime dateRequested, String requestor, String workOrder) {
    super(dateRequested, requestor);
    this.workOrder = workOrder;
  }

  public MaterialIssueRequest(LocalDateTime dateRequested, String requestor, String id, String workOrder) {
    super(dateRequested, requestor, id);
    this.workOrder = workOrder;
  }

  public MaterialIssueRequest(LocalDateTime dateRequested, String requestor, String workOrder, String... inventoryItems) {
    super(dateRequested, requestor, inventoryItems);
    this.workOrder = workOrder;
  }

  public MaterialIssueRequest(LocalDateTime dateRequested, String requestor, String id, String workOrder, String... inventoryItems) {
    super(dateRequested, requestor, id, inventoryItems);
    this.workOrder = workOrder;
  }

  public String getWorkOrder() {
    return workOrder;
  }

  public void setWorkOrder(String workOrder) {
    this.workOrder = workOrder;
  }

}
