package com.stevensherry.gui;

import com.stevensherry.clientclasses.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.time.*;
import java.util.*;

/**
 * Created by steven.sherry on 6/22/2017.
 */
public class Dashboard extends GridPane{
  private List<Request> requestList;
  @FXML
  private ListView<Request> requestListView;

  public void initialize() {
    BomRequest bomRequest = new BomRequest(LocalDateTime.now().plusDays(1),
        "me","187523");
    CycleCountRequest cycleCountRequest =
        new CycleCountRequest(LocalDateTime.now().plusDays(3), "me");
    MaterialIssueRequest materialIssueRequest =
        new MaterialIssueRequest(LocalDateTime.now().plusDays(2),"me",
            "2513");
    AdjustmentRequest adjustmentRequest =
        new AdjustmentRequest(LocalDateTime.now().plusDays(5),"me",
            "stuff");
    requestList = new ArrayList<>();
    requestList.add(bomRequest);
    requestList.add(cycleCountRequest);
    requestList.add(materialIssueRequest);
    requestList.add(adjustmentRequest);

    requestListView.getItems().setAll(requestList);
    requestListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
  }

}
