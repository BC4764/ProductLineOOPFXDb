package sample;

/** @author - Benjamin Cano */
public class Product implements Item {

  public int productID;
  Item type;
  public String manufacturer;
  public String name;

  /**
   * Constructor that sets values to the variables.
   *
   * @param name - name.
   * @param manufacturer - manufacturer.
   * @param type - type.
   */
  Product(String name, String manufacturer, Item type) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
  }

  public int getProductID() {
    return productID;
  }

  public void setProductID(int productID) {
    this.productID = productID;
  }

  public Item getType() {
    return type;
  }

  public void setType(Item type) {
    this.type = type;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String toString() {

    return "Name:" + name + "\nManufacturer: " + manufacturer + "\nType: " + type;
  }
}
