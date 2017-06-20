package com.stevensherry.clientclasses;

/**
 * Created by stevensherry on 6/13/17.
 */
public class CreateMaterialRequest extends Request {
  private String manufacturerSKU;
  private String description;


  public CreateMaterialRequest(String manufacturerSKU, String description,
                               String requestor, String dateRequested) {
    super(dateRequested, requestor);
    this.manufacturerSKU = manufacturerSKU;
    this.description = description;
  }

  public CreateMaterialRequest(String manufacturerSKU, String description, String requestor,
                               String dateRequested, String id) {
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

//  public void writeJsonStream(OutputStream out, CreateMaterialRequest request) throws IOException {
//    JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
//    writer.setIndent("  ");
//    writeCreateMaterialRequestObject(writer, request);
//    writer.close();
//  }
//
//  public void writeCreateMaterialRequestObject(JsonWriter writer, CreateMaterialRequest materialRequest) throws
//      IOException {
//    writer.beginObject();
//    if(materialRequest.id != null) {
//      writer.name("id").value(materialRequest.getId());
//    }
//  }

}
