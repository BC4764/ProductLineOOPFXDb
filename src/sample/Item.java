package sample;

/**
 * Interface that calls getters and setters
 *
 * @author - Benjamin Cano
 */
interface Item {

  /**
   * get product ID.
   *
   * @return null.
   */
  int getProductID();

  /**
   * set name.
   *
   * @param name - name.
   */
  void setName(String name);

  /**
   * get name.
   *
   * @return null.
   */
  String getName();

  /**
   * set manufacturer.
   *
   * @param manufacturer - manufacturer.
   */
  void setManufacturer(String manufacturer);

  /**
   * get manufacturer.
   *
   * @return null.
   */
  String getManufacturer();
}
