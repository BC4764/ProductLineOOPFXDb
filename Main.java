// benjamin cano
// Date: 9/16/2019
// main file of project that pulls most info

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("SceneB.fxml"));
    primaryStage.setTitle("Production Line Tracker");
    primaryStage.setScene(new Scene(root, 640, 405));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
