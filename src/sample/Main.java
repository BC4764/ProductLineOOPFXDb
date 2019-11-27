package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * A program where users will input data about the products that they make into a database.
 *
 * @author Benjamin Cano
 */
public class Main extends Application { // inspection code warning: Entry point.

  /**
   * @param primaryStage the first thing the user sees
   * @throws Exception for the stage
   */
  @Override
  public void start(Stage primaryStage) throws Exception { // inspection code warning: Entry point.
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    Scene scene = new Scene(root, 600, 425);
    primaryStage.setTitle("Product Tracker");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * method for a String.
   *
   * @param args - a String.
   */
  public static void main(String[] args) { // inspection code warning: Entry point.
    launch(args);
  }
}
