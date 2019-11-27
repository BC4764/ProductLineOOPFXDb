package sample;

/**
 * class that extends Product.
 *
 * @author Benjamin Cano
 */
class Widget extends Product {
  /**
   * Constructor that uses variables from the Product class.
   *
   * @param name - name of product.
   * @param manufacturer - manufacturer of product.
   * @param type - type of manufacturer.
   */
  public Widget(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type);
  }
}
