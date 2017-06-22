package com.stevensherry.gui;

import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;

import java.io.*;

/**
 * Created by steven.sherry on 6/22/2017.
 */
public class Dashboard {
  @FXML
  ObservableList something = FXCollections.observableArrayList();
  @FXML
  static ListView choiceBox2;
  static {
    choiceBox2 = new ListView();
    choiceBox2.setItems(FXCollections.observableArrayList("Here","There","Somewhere"));
  }

  public Dashboard() throws IOException {


  }
}
