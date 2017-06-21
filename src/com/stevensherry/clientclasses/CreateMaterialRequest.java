package com.stevensherry.clientclasses;

import java.time.*;

/**
 * Created by stevensherry on 6/13/17.
 */
public class CreateMaterialRequest extends Request {
  private String manufacturerSKU;
  private String description;


  public CreateMaterialRequest(String manufacturerSKU, String description,
                               String requestor, LocalDateTime dateRequested) {
    super(dateRequested, requestor);
    this.manufacturerSKU = manufacturerSKU;
    this.description = description;
  }

  public CreateMaterialRequest(String manufacturerSKU, String description, String requestor,
                               LocalDateTime dateRequested, String id) {
    super(dateRequested, requestor, id);
    this.manufacturerSKU = manufacturerSKU;
    this.description = description;
  }

  public String getManufacturerSKU() {
    return manufacturerSKU;
  }

  public String getDescription() {
    return description;
  }

}
