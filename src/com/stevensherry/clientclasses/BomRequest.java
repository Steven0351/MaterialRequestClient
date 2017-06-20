package com.stevensherry.clientclasses;

/**
 * Created by steven.sherry on 6/20/2017.
 */
public class BomRequest extends CycleCountRequest{

  private String proposedTopLevelID;

  public BomRequest(String dateRequested, String requestor, String proposedTopLevelID) {
    super(dateRequested, requestor);
    this.proposedTopLevelID = proposedTopLevelID;
  }

  public BomRequest(String dateRequested, String requestor, String id, String proposedTopLevelID) {
    super(dateRequested, requestor, id);
    this.proposedTopLevelID = proposedTopLevelID;
  }

  public BomRequest(String dateRequested, String requestor, String proposedTopLevelID, String... inventoryItems) {
    super(dateRequested, requestor, inventoryItems);
    this.proposedTopLevelID = proposedTopLevelID;
  }

  public BomRequest(String dateRequested, String requestor, String id, String proposedTopLevelID, String... inventoryItems) {
    super(dateRequested, requestor, id, inventoryItems);
    this.proposedTopLevelID = proposedTopLevelID;
  }

  public String getProposedTopLevelID() {
    return proposedTopLevelID;
  }

  public void setProposedTopLevelID(String proposedTopLevelID) {
    this.proposedTopLevelID = proposedTopLevelID;
  }

}
