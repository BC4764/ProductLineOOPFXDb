// benjamin cano
//Date: 9/16/2019
// main file of project that pulls most info

package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.ComboBox;

class Main { private ComboBox<String> cboTableName = new ComboBox<>();

  public static void main(String[] args) {
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/HR";

    final String USER = "";      //  Database credentials
    final String PASS = "";
    Connection conn;
    Statement stmt;
    try {
        Class.forName(JDBC_DRIVER);    // STEP 1: Register JDBC driver
        conn = DriverManager.getConnection(DB_URL, USER, PASS); //STEP 2: Open a connection
        stmt = conn.createStatement();       //STEP 3: Execute a query

        String sql = "SELECT * FROM PRODUCT";
        stmt.executeUpdate(sql);
        sql = "INSERT INTO PRODUCT (NAME, TYPE, MANUFACTURER) "
            + "VALUES ('iPod','AUDIO','Apple')";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
    } catch (ClassNotFoundException | SQLException e) {         // STEP 4: Clean-up environment
        e.printStackTrace();

    }
  }
}
