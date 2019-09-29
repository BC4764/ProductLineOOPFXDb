// benjamin cano
// Date: 9/16/2019
// extra code that is used or pulled from main

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

public class Controller {
  @FXML private Text actiontarget;

  @FXML
  protected void handleSubmitButtonAction(ActionEvent event) { // event handler for buttons
    actiontarget.setText("System.out.println");
  }

  public void initialize() { // initializing 10 values
    int[] data = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  }

  @FXML private ComboBox<String> cboTableName;

  @FXML
  private void Combo(ActionEvent event) { // allow the users to enter other values in the combobox
    cboTableName.setEditable(true);
    cboTableName.getSelectionModel().selectFirst();
  }
}
