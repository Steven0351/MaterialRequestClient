package com.stevensherry.clientclasses;

import java.time.*;

/**
 * Created by steven.sherry on 6/20/2017.
 */
public class AdjustmentRequest extends CycleCountRequest {
  private String reason;

  public AdjustmentRequest(LocalDateTime dateRequested, String requestor, String reason) {
    super(dateRequested, requestor);
    this.reason = reason;
  }

  public AdjustmentRequest(LocalDateTime dateRequested, String requestor, String id, String reason) {
    super(dateRequested, requestor, id);
    this.reason = reason;
  }

  public AdjustmentRequest(LocalDateTime dateRequested, String requestor, String reason, String... inventoryItems) {
    super(dateRequested, requestor, inventoryItems);
    this.reason = reason;
  }

  public AdjustmentRequest(LocalDateTime dateRequested, String requestor, String id, String reason, String... inventoryItems) {
    super(dateRequested, requestor, id, inventoryItems);
    this.reason = reason;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

}
