package sample;

import java.util.Date;

public class ProductionRecord {
  // private String manufacturer;
  private int ProdNum;
  private int productID;
  private String serialNumber;
  private Date DateOfProduction;

  public ProductionRecord(Product productProduced, int itemCount) {
    String idNum = String.format("%05d", itemCount);
    this.serialNumber =
        productProduced.manufacturer.substring(0, 3)
            + productProduced.getType().getValues()
            + idNum;
    this.DateOfProduction = new Date();
  }

  public ProductionRecord(int productID) {
    this.productID = productID;
    ProdNum = 0;
    serialNumber = "0";
    DateOfProduction = new Date();
  }

  public ProductionRecord(
      int ProdNum, int productID, String serialNumber, Date DateOfProduction) {
    this.ProdNum = ProdNum;
    this.productID = productID;
    this.serialNumber = serialNumber;
    this.DateOfProduction = DateOfProduction;
  }

  public String toString() {
    return "Prod. Num: "
        + ProdNum
        + " Product ID: "
        + productID
        + " Serial Num: "
        + serialNumber
        + " Date: "
        + DateOfProduction;
  }
}
