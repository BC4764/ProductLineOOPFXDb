package sample;

/**
 * Abstract class that has fields for the products and getters/setter methods for those fields.
 * implements the Item class.
 *
 * @author - Benjamin Cano
 */
public abstract class Product implements Item {

  private int productID;
  private final ItemType type;
  public String manufacturer;
  private String name;

  /**
   * Constructor that sets values to the variables.
   *
   * @param name - name.
   * @param manufacturer - manufacturer.
   * @param type - type.
   */
  Product(String name, String manufacturer, ItemType type) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
  }
  /**
   * get Type of product.
   *
   * @return - Type.
   */
  public ItemType getType() {
    return type;
  }

  /**
   * get product ID.
   *
   * @return - productID.
   */
  public int getProductID() {
    return productID;
  }

  /**
   * get manufacturer of product.
   *
   * @return - manufacturer.
   */
  public String getManufacturer() {
    return manufacturer;
  }

  /**
   * set manufacturer to manufacturer.
   *
   * @param manufacturer - manufacturer of product.
   */
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   * get name of product.
   *
   * @return - name.
   */
  public String getName() {
    return name;
  }

  /**
   * set name of product.
   *
   * @param name - name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * prints out a string about the products name, manufacturer, and type
   *
   * @return - String.
   */
  public String toString() {
    return "Name: " + name + '\n' + "Manufacturer: " + manufacturer + '\n' + "Type: " + type + '\n';
  }
}
