package sample;

import java.util.Date;

/**
 * Keeps count of the products produced and prints out information about the products that have been
 * produced, including the production number, ID, serial number, and date produced.
 *
 * @author - Benjamin Cano
 */
public class ProductionRecord {

  public int productionNumber;
  public int productID;
  public String serialNumber;
  public Date dateProduced;

  /**
   * Constructor that sets variables to their values.
   *
   * @param productProduced - Instance of Product.
   * @param itemCount - integer that keeps count on the number of items
   */
  public ProductionRecord(Product productProduced, int itemCount) {
    String itemC = String.format("%05d", itemCount);
    dateProduced = new Date();
    serialNumber =
        productProduced.getManufacturer().substring(0, 3) + productProduced.getType() + itemC;
    this.productionNumber = 0;
    this.productID = productProduced.getProductID();
    this.dateProduced = new Date(dateProduced.getTime());
  }

  /**
   * Constructor that sets the values to the variables.
   *
   * @param productionNum1 - production number of product.
   * @param productID1 - Id of product.
   * @param serialNum1 - serial number of product.
   * @param dateProduced - date produced of product.
   */
  public ProductionRecord(
      int productionNum1, int productID1, String serialNum1, Date dateProduced) {
    this.productionNumber = productionNum1;
    this.productID = productID1;
    this.serialNumber = serialNum1;
    this.dateProduced = new Date(dateProduced.getTime());
  }

  /**
   * Prints out a String that gives information about the Product.
   *
   * @return - a String.
   */
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

  public int getProductionNumber() {
    return productionNumber;
  }

  public void setProductionNumber(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  public int getProductID() {

    return productID;
  }

  public void setProductID(int productID) {

    this.productID = productID;
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNum(String serialNum) {
    this.serialNumber = serialNumber;
  }

  public Date getDateProduced() {
    return dateProduced;
  }

  public void setDateProduced(Date dateProduced) {
    this.dateProduced = dateProduced;
  }
}
