package com.stevensherry.gui;
/**
 * Created by steven.sherry on 6/22/2017.
 */


import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.io.*;
import java.net.*;

public class Main extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  private static BorderPane root = new BorderPane();

  public static BorderPane getRoot() {
    return root;
  }

  @Override
  public void start(Stage primaryStage) throws IOException {
    URL menuBarUrl = getClass().getResource("MenuBar.fxml");
    MenuBar menuBar = FXMLLoader.load(menuBarUrl);

    URL dashboardUrl = getClass().getResource("Dashboard.fxml");
    GridPane dashboard = FXMLLoader.load(dashboardUrl);
    root.setTop(menuBar);
    root.setCenter(dashboard);

    InputStream iconURL = getClass().getResourceAsStream("png-gdt-bug.png");

    Scene scene = new Scene(root, 845,710);
    primaryStage.setTitle("GDT Manufacturing Portal");
    primaryStage.getIcons().add(new Image(iconURL));
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
