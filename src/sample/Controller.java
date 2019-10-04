// benjamin cano
// Date: 9/16/2019
// extra code that is used or pulled from main

package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;

@SuppressWarnings("ALL")
public class Controller {
  /** data base connectivity is established */
  private static final String jcbdDriver = "org.h2.Driver";

  private static final String dbUrl =
      "jdbc:h2:./res/ProductionDB";

  private static final String user = "username";

  private static final String pass = "password";

  private Connection conn = null;

  private Statement stmt = null;
  /** Each component that will be used in the FXML from SceneBuilder */
  @FXML private TextField prod_NameTxtBox;

  @FXML private TextField manufact_TxtBox;
  @FXML private ChoiceBox<?> type_Choicebox;
  @FXML private TableColumn<?, ?> exist_Products;
  @FXML private Button add_Button;
  @FXML private Button record_ProductionBtn;
  /** Main method of the controller to establish connection */
  public static void main(String[] args) {
    System.out.println("Database Connected");
  }
  /** will display the products that are currently in the database */
  @FXML
  void display_products(CellEditEvent<?, ?> event) {
    /** the try statement is used to call the driver and to connect the the database */
    try {
      Class.forName(jcbdDriver);
      conn = DriverManager.getConnection(dbUrl, user, pass);
      stmt = conn.createStatement();
      String sql = "SELECT * FROM PRODUCT";
      ResultSet rs = stmt.executeQuery(sql);
      /** loop is made to display the information entered line by line */
      while (rs.next()) {
        System.out.println(rs.getString(1));
      } // End of while.
      stmt.close();
      conn.close();
      /** the catch is used so the application is not terminated and is able to function */
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    } // End of catch.
  }
  /** this is the function that will allow the user to enter products to the database */
  @FXML
  void add_product(MouseEvent event) {
    try {
      Class.forName(jcbdDriver);

      conn = DriverManager.getConnection(dbUrl, user, pass);

      stmt = conn.createStatement();

      String sql =
          "INSERT INTO PRODUCT(NAME, TYPE, MANUFACTURER) VALUES('NAME', 'TYPE', 'MANUFACTURER')";

      stmt.executeUpdate(sql);
      stmt.close();
      conn.close();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
    System.out.println("Product Added");
  }
  /** this function is for the button labeled record production */
  @FXML
  void record_production(MouseEvent event) {
    System.out.println("Your product has been recorded");
  }
  /** this function is to take the input entered in the text box */
  public void input_products(CellEditEvent<?, ?> cellEditEvent) {
    System.out.println("Product name has been entered");
  }
  /** function to display different production types into the choice box */
  public void display_types(ContextMenuEvent contextMenuEvent) {
    System.out.println("Production types have now been updated.");
  }
  /** this function will take in the users input from the text box and store it */
  public void getProductName(MouseEvent mouseEvent) {
    System.out.println("Product name has been selected.");
  }
  /** this function will take in the users input that is put in the manufacturer text box */
  public void getManufacturer(MouseEvent mouseEvent) {
    System.out.println("Manufactuer has been selected.");
  }
  /** this function is used by the choice box */
  public void getType(MouseEvent mouseEvent) {
    System.out.println("Type has been selected.");
  } // End of getType.
}
