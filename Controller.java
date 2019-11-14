/**
 * ********************************************************* File : Controller.Java Author(s) :
 * Benjamin Cano Class : COP 3003 Purpose : File containing the main functionality of the program.
 * **********************************************************
 */
package sample;

import java.sql.*; // checkstyle warning
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/** code that controls what happens whenever an event occurs. */
@SuppressWarnings("ALL")
public class Controller {
  @FXML private Button AddProductButton;

  @FXML private ComboBox ProduceComboBox;

  @FXML private Button RecordProduction;

  @FXML private ChoiceBox ChooseType;

  @FXML private TextArea txtArea_ProdLog;

  @FXML private TextField ProdName_TxtField;

  @FXML private TextField Manufacturer_TxtField;

  @FXML private TableView<Product> ExistingProd;

  @FXML private TableColumn<?, ?> ProdNameCol;

  @FXML private TableColumn<?, ?> ManufacturerCol;

  @FXML private TableColumn<?, ?> TypeCol;

  @FXML private ListView<Product> ProdListView;

  private Connection conn;

  /** observable list creation used for table view */
  private ObservableList<Product> productLine = FXCollections.observableArrayList();

  @FXML
  public void handleRecordButtonAction() {}

  /**
   * button is used to add a name, manufacturer, and an item type to record in to the database and
   * displays it in the table view
   */
  public void handleAddButtonAction() throws SQLException {
    // Defining an observable list
    // Initializing variables of the textfields
    String productName = ProdName_TxtField.getText();
    String productManufacturer = Manufacturer_TxtField.getText();
    String chooseType = String.valueOf(ChooseType.getValue());

    // used so the database accepts input from the user
    String data = "INSERT INTO PRODUCT (NAME, MANUFACTURER, TYPE) VALUES(?,?,?)";

    // prepared statement/connection
    PreparedStatement preparedStatement = conn.prepareStatement(data);

    preparedStatement.setString(1, productName);
    preparedStatement.setString(2, productManufacturer);
    preparedStatement.setString(3, chooseType);
    preparedStatement.executeUpdate();

    System.out.println("Product has been added");

    // used to clear the text fields
    ProdName_TxtField.clear();
    Manufacturer_TxtField.clear();

    // when the button is pressed the tableview will populate with what the user has input
    ProdNameCol.setCellValueFactory(new PropertyValueFactory<>("ProdNamwCol"));
    ManufacturerCol.setCellValueFactory(new PropertyValueFactory<>("ManufacturerCol"));
    TypeCol.setCellValueFactory(new PropertyValueFactory<>("TypeCol"));

    // sets the items to the observable list
    ExistingProd.setItems(productLine);

    productLine.add(new Widget(productName, productManufacturer, ItemType.valueOf(chooseType)));

    // sets the info from product line to the list view
    ProdListView.setItems(productLine);

    // cleans up the environment
    preparedStatement.close();
    conn.close();
  }
  /** Populate the comboBox with 1-10 values.  */
  public void initialize() {
    // call to initizalize the database
    initializeData();

    // observable list is used to populate the comboBox
    ObservableList<Integer> list = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    ProduceComboBox.setItems(list);
    ProduceComboBox.getSelectionModel().selectFirst();
    ProduceComboBox.setEditable(true);

    // for loop that populates item choices
    ObservableList<String> itemList = FXCollections.observableArrayList();
    for (ItemType typeItem : ItemType.values()) {
      System.out.println(typeItem + " " + typeItem.values);
      itemList.add(String.valueOf(typeItem));
    }
    ChooseType.getItems().addAll(itemList);

    ProductionRecord prodRec = new ProductionRecord(0);
    String prod = prodRec.toString();
    txtArea_ProdLog.setText(prod);
  }
  /** Initializes the database by registering the JDBC driver and opening a connection. */
  private void initializeData() {
    // Connection information
    final String jdbcDriver = "org.h2.Driver"; // checkstyle warning
    final String dbUrl = "jdbc:h2:./res/H2"; // checkstyle warning
    System.out.println("Attempting to connect to the database...");
    try {
      // Register JDBC driver
      Class.forName(jdbcDriver);

      // Open a connection
      conn = DriverManager.getConnection(dbUrl);

      System.out.println("Successfully connected to the database!");
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }
}
