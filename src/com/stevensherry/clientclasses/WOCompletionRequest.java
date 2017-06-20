package com.stevensherry.clientclasses;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by steven.sherry on 6/20/2017.
 */
public class WOCompletionRequest extends Request {

  private ArrayList<String> workOrders;

  public WOCompletionRequest(String dateRequested, String requestor, String... workOrders) {
    super(dateRequested, requestor);
    this.workOrders = new ArrayList<>(Arrays.asList(workOrders));
  }

  public ArrayList<String> getWorkOrders() {
    return new ArrayList<>(workOrders);
  }

  public boolean addWorkOrder(String workOrder) {
    return workOrders.add(workOrder);
  }

  public boolean addWorkOrder(String... workOrders) {
    return this.workOrders.addAll(Arrays.asList(workOrders));
  }

}
