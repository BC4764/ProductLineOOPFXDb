package sample;

import java.util.Date;
import sample.Product;

public class ProductionRecord {
  // private String manufacturer;
  private int productionNumber;
  private int productID;
  private String serialNumber;
  private Date dateProduced;

  public ProductionRecord(Product productProduced, int itemCount) {
    String idNum = String.format("%05d", itemCount);
    this.serialNumber =
        productProduced.manufacturer.substring(0, 3)
            + productProduced.getType().getValues()
            + idNum;
    this.dateProduced = new Date();
  }

  public ProductionRecord(int productID) {
    this.productID = productID;
    productionNumber = 0;
    serialNumber = "0";
    dateProduced = new Date();
  }

  public ProductionRecord(
      int productionNumber, int productID, String serialNumber, Date dateProduced) {
    this.productionNumber = productionNumber;
    this.productID = productID;
    this.serialNumber = serialNumber;
    this.dateProduced = dateProduced;
  }

  public String toString() {
    return "Prod. Num: "
        + productionNumber
        + " Product ID: "
        + productID
        + " Serial Num: "
        + serialNumber
        + " Date: "
        + dateProduced;
  }
}
