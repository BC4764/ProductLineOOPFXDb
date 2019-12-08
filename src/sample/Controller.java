/**
 * ********************************************************* File : Controller.Java Author(s) :
 * Benjamin Cano Class : COP 3003 Purpose : File containing the main functionality of the program.
 * **********************************************************
 */
package sample;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

/** code that controls what happens whenever an event occurs. */
public class Controller implements Initializable {

  @FXML private TextField EmployeeName;

  @FXML private TextField EmployeePassword;

  @FXML private Button CreateAccountIDButton;

  @FXML private Label NameOfEmployee;

  @FXML private Label EmployeeUser;

  @FXML private Label EmployeeEmail;

  @FXML private Label PasswordOfEmployee;

  @FXML private Button ShowPasswordBtn;

  @FXML private Button HidePasswordBtn;

  @FXML private Label Error;

  @FXML private TextField ProdName_TxtField;

  @FXML private TextField Manufacturer_TxtField;

  @FXML private ChoiceBox<?> ChooseType;

  @FXML private Button AddProductButton;

  @FXML private TableView<Product> ExistingProd;

  @FXML private TableColumn<?, ?> ProdNameCol;

  @FXML private TableColumn<?, ?> ManufacturerCol;

  @FXML private TableColumn<?, ?> TypeCol;

  @FXML private ListView<Product> ProdListView;

  @FXML private ComboBox<?> ProduceComboBox;

  @FXML private Button RecordProduction;

  @FXML private TextArea txtArea_ProdLog;

  @FXML private Label ProductionLineError;

  /** observable list creation used for table view */
  private ObservableList<Product> productLine = FXCollections.observableArrayList();

  Statement stmt;

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    try {
      loadProductList();
      loadProductionLog();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    ProduceComboBox.setItems(options);
    ProduceComboBox.setEditable(true);
    ProdListView.setItems(productLine);
    ShowPasswordBtn.setVisible(false);
    HidePasswordBtn.setVisible(false);
    setErrorLabels();
  }

  final String JDBC_DRIVER = "org.h2.Driver";
  final String DB_URL = "jdbc:h2:./res/H2";
  //  Database credentials
  final String USER = "";
  String PASS = "test";

  Connection conn;

  @FXML
  public void handleRecordButtonAction() {
    ObservableList<ProductionRecord> productionRun = FXCollections.observableArrayList();
    Product productRec = ProdListView.getSelectionModel().getSelectedItem();
    int quantity = Integer.parseInt(String.valueOf(ProduceComboBox.getValue()));

    try {
      for (int num = 1; num <= quantity; num++) {
        ProductionRecord produceRecord = new ProductionRecord(productRec, num);
        productionRun.addAll(produceRecord);
        txtArea_ProdLog.appendText(productRec.toString() + "\n");
        addToProductionDB(produceRecord);
        System.out.println(produceRecord);
        loadProductionLog();
      }

    } catch (Exception e) {
      System.out.println("Something went wrong\n");
    }
  }

  /**
   * button is used to add a name, manufacturer, and an item type to record in to the database and
   * displays it in the table view
   */
  public void handleAddButtonAction() throws SQLException {
    StoreToDB();
    ProdListView.setItems(productLine);
  }

  @FXML
  void handleComboBox() {
    ProduceComboBox.getSelectionModel().getSelectedItem();
  }

  public void addToProductionDB(ProductionRecord productionRecord) {

    int id = productionRecord.productID;
    String serialNumber = productionRecord.serialNumber;
    Timestamp dateProduced = new Timestamp(productionRecord.getDateProduced().getTime());

    try {
      String sql =
          "INSERT INTO PRODUCTIONRECORD (PRODUCT_ID, SERIAL_NUM, DATE_PRODUCED) VALUES (?,?,?)";
      Class.forName(JDBC_DRIVER);
      Connection conn = DriverManager.getConnection(DB_URL);
      System.out.println("Recording Information");
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, id);
      ps.setString(2, serialNumber);
      ps.setTimestamp(3, dateProduced);
      ps.executeUpdate();
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    System.out.println(id + " " + serialNumber + " " + dateProduced + "\n");
  }

  ObservableList options = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

  @FXML List<String> iList = new ArrayList<>();
  ObservableList iOptions = FXCollections.observableArrayList();

  @FXML
  void itemTypes() {
    for (ItemType it : ItemType.values()) {

      iList.add(it.getType());
    }
    iOptions.addAll(iList);
    ChooseType.setItems(iOptions);
  }

  private void loadProductList() throws SQLException {
    String name;
    String manufacturer;
    String type;

    String sql = "SELECT NAME,MANUFACTURER,TYPE FROM Product";
    productLine = FXCollections.observableArrayList();
    try {
      Connection conn = DriverManager.getConnection(DB_URL);
      PreparedStatement stmt = conn.prepareStatement(sql);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        name = rs.getString("NAME");
        manufacturer = rs.getString("MANUFACTURER");
        type = rs.getString("TYPE");

        ExistingProd.setItems(productLine);
        productLine.addAll(new Product(name, manufacturer, ItemType.valueOf("AUDIO")));
        ExistingProd.setItems(productLine);
      }

      ProdNameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
      ManufacturerCol.setCellValueFactory(new PropertyValueFactory<>("Manufacturer"));
      TypeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));

      conn.close();
      stmt.close();

    } catch (SQLException | IllegalArgumentException e) {
      e.printStackTrace();
    }
  }

  private void StoreToDB() throws SQLException {

    String name = ProdName_TxtField.getText();
    String manufacturer = Manufacturer_TxtField.getText();
    String item = (String) ChooseType.getSelectionModel().getSelectedItem();

    if (name.isEmpty() && manufacturer.isEmpty()) {
      ProductionLineError.setVisible(true);
    } else {

      String sql = "INSERT INTO PRODUCT (ID ,NAME, MANUFACTURER, TYPE) VALUES (?,?,?,?)";
      try {
        Class.forName(JDBC_DRIVER); // Database Driver
        Connection conn = DriverManager.getConnection(DB_URL);
        System.out.println("Recording Production");
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, null);
        ps.setString(2, name);
        ps.setString(3, manufacturer);
        ps.setString(4, String.valueOf(item));
        ps.executeUpdate();

      } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
        Alert a = new Alert(AlertType.ERROR);
        System.out.println("Recording Unsuccessful");
      }

      loadProductList();
      ProductionLineError.setVisible(false);
    }
  }

  private void loadProductionLog() throws SQLException {

    int prodNumber;
    int prodID;
    String serialNumber;
    Timestamp dateOfProduction;
    String sql =
        "SELECT PRODUCTION_NUM,PRODUCT_ID,SERIAL_NUM,SERIAL_NUM,DATE_PRODUCED FROM "
            + "PRODUCTIONRECORD";
    try {
      Connection conn = DriverManager.getConnection(DB_URL);
      PreparedStatement stmt = conn.prepareStatement(sql);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        prodNumber = rs.getInt("PRODUCTION_NUM");
        prodID = rs.getInt("PRODUCT_ID");
        serialNumber = rs.getString("SERIAL_NUM");
        dateOfProduction = rs.getTimestamp("DATE_PRODUCED");

        System.out.println(prodNumber + prodID + serialNumber + dateOfProduction);

        ProductionRecord proRec = new ProductionRecord(prodNumber, prodID, serialNumber, dateOfProduction);

        ObservableList<ProductionRecord> productionLog = FXCollections.observableArrayList();
        productionLog.setAll(proRec);
        txtArea_ProdLog.appendText(String.valueOf(productionLog) + "\n");
      }

    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println();
    }
  }

  /** creates employee ID/account */
  @FXML
  void CreateEmployeeAccount() {

    String name = EmployeeName.getText();
    String pass = EmployeePassword.getText();
    Employee employee = new Employee(name, pass);
    String realName = employee.getName();
    String realUserName = employee.getUsername();
    String realEmail = employee.getEmail();
    String realPassword = employee.getPassword();

    if (name.isEmpty() || pass.isEmpty()) {

      System.out.println("Please enter info in fields");
      Error.setVisible(true);
    } else {

      NameOfEmployee.setText(realName);
      EmployeeUser.setText(realUserName);
      EmployeeEmail.setText(realEmail);
      PasswordOfEmployee.setText(realPassword);
      PasswordOfEmployee.setVisible(false);
      CreateAccountIDButton.setVisible(false);
      ShowPasswordBtn.setVisible(true);
      Error.setVisible(false);
    }

    System.out.println(employee);
  }

  /** This will toggle between showing and hiding the employee's password */
  @FXML
  void ShowPassword() {
    PasswordOfEmployee.setVisible(true);
    ShowPasswordBtn.setVisible(false);
    HidePasswordBtn.setVisible(true);
  }

  @FXML
  void HidePass() {
    PasswordOfEmployee.setVisible(false);
    ShowPasswordBtn.setVisible(true);
    HidePasswordBtn.setVisible(false);
  }
  /** ********************************************************* */
  /** this method will set all error messages to false */
  void setErrorLabels() {
    Error.setVisible(false);
    ProductionLineError.setVisible(false);
  }

  public String reverseString(String pw) {
    this.PASS = pw;

    for (int i = pw.length() - 1; i >= 0; i--) {
      pw = pw + pw.charAt(i);
    }
    return pw;
  }
}
