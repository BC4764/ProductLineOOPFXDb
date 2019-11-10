/**
 * ********************************************************* File : Controller.Java Author(s) :
 * Benjamin Cano Class : COP 3003 Purpose : File containing the main functionality of the program.
 * **********************************************************
 */
package sample;

import java.sql.*; // checkstyle warning
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

/** code that controls what happens whenever an event occurs. */
@SuppressWarnings("ALL")
public class Controller { // code inspection error: can be private
  @FXML public Button AddProductButton; // checkstyle warning
  @FXML private ComboBox ProduceComboBox; // checkstyle warning
  @FXML public Button RecordProduction; // checkstyle warning
  @FXML private ChoiceBox ChooseType; // checkstyle warning
  @FXML private TextArea txtArea_ProdLog;

  /** - Button is clicked to add a product. */
  public void handleAddButtonAction() {
    // Button was clicked, print this
    System.out.println("product added");
  }

  /** button clicked to add a record to database. */
  @FXML
  public void handleRecordButtonAction() {
    // button was clicked, print this
    System.out.println("");
  }
@FXML
public void setTxtArea_ProdLog(){
    txtArea_ProdLog.setText(toString());
}
  /** drop down menu clicked to choose an item. */
  public void handleChooseItem() {} // checkstyle wants } on separate line

  /** Populate the comboBox with 1-10 values. Allow user to type in a number instead of clicking. */
  public void initialize() {

    final String jdbcDriver = "org.h2.Driver"; // checkstyle warning
    final String dbUrl = "jdbc:h2:./res/H2"; // checkstyle warning


    // Database Credentials
    Connection conn;
    Statement stmt;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(jdbcDriver);

      // Step 2: Open a connection
      conn = DriverManager.getConnection(dbUrl);

      // Step 3: Execute a query
      stmt = conn.createStatement();

      String sq1 = "INSERT INTO PRODUCT(NAME, TYPE, MANUFACTURER) VALUES('iPod', 'AUDIO', 'Apple')";

      stmt.executeUpdate(sq1);

      // STEP 4: Clean up environment
      stmt.close();
      conn.close();

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    for (int i = 0; i <= 10; i++) {
      ProduceComboBox.getItems().add(i);
    }
    ProduceComboBox.getSelectionModel().selectFirst();
    ProduceComboBox.setEditable(true);

    // enhanced for loop to populate the item choices
    for (ItemType it : ItemType.values()) {
      System.out.println(it + " " + it.values);
      ChooseType.getItems().addAll(ItemType.values());
    }
  }
}
