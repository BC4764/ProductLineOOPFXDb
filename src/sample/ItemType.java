package sample;

/**
 * Enum to give each item type a 2 letter code
 *
 * @author Benjamin Cano
 */
public enum ItemType {
  Audio("AU"),
  Visual("VI"),
  AudioMobile("AM"),
  VisualMobile("VM");

  // String variable.
  public final String values;

  /**
   * constructor that sets a value to the variable.
   *
   * @param value - value.
   */
  ItemType(String value) {
    values = value;
  }

  /**
   * Getter method.
   *
   * @return - values.
   */
  public String getValues() {
    return this.values;
  }
}
