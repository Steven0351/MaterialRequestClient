package com.stevensherry.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;


/**
 * Created by steven.sherry on 6/22/2017.
 */
public class MenuBarController {
  @FXML
  private MenuItem newRequest;
  @FXML
  private MenuItem logout;

  @FXML
  void createNewRequest(ActionEvent event) {
    System.out.println("New Request clicked");
  }

  @FXML
  void logout(ActionEvent event) {
    System.out.println("Logout clicked");
  }

}
