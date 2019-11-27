/**
 * ********************************************************* File : Controller.Java Author(s) :
 * Benjamin Cano Class : COP 3003 Purpose : File containing the main functionality of the program.
 * **********************************************************
 */
package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
/** code that controls what happens whenever an event occurs. */
public class Controller {
  @FXML private Button AddProductButton;

  @FXML private ComboBox ProduceComboBox;

  @FXML private Button RecordProduction;

  @FXML private ChoiceBox<String> ChooseType;

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

    String productName = ProdName_TxtField.getText();
    String productManufacturer = Manufacturer_TxtField.getText();
    String chooseType = ChooseType.getValue();

    String data = "INSERT INTO PRODUCT (NAME, TYPE, MANUFACTURER) VALUES(?,?,?)";

    PreparedStatement preparedStm = conn.prepareStatement(data);
    preparedStm.setString(1, productName);
    preparedStm.setString(2, productManufacturer);
    preparedStm.setString(3, chooseType);
    preparedStm.executeUpdate();
    System.out.println("Product has been added");

    ProdName_TxtField.clear();
    Manufacturer_TxtField.clear();

    ProdNameCol.setCellValueFactory(new PropertyValueFactory<>("Product Name"));
    ManufacturerCol.setCellValueFactory(new PropertyValueFactory<>("Manufacturer"));
    TypeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));

    ExistingProd.setItems(productLine);
    productLine.add(new Widget(productName, productManufacturer, ItemType.valueOf(chooseType)));

    ProdListView.setItems(productLine);

    preparedStm.close();
    conn.close();
  }
  /** Populate the comboBox with 1-10 values. */
  public void initialize() {

    initializeData();

    ObservableList<Integer> list = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    ProduceComboBox.setItems(list);
    ProduceComboBox.getSelectionModel().selectFirst();
    ProduceComboBox.setEditable(true);

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

    final String jdbcDriver = "org.h2.Driver";
    final String dbUrl = "jdbc:h2:./res/H2";

    try {
      Class.forName(jdbcDriver);
      conn = DriverManager.getConnection(dbUrl);
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }
}
