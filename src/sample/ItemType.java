package sample;

import javafx.scene.control.ChoiceBox;

/**
 * Enum to give each item type a 2 letter code
 *
 * @author Benjamin Cano
 */
public enum ItemType implements Item {
  AUDIO("AU", "Audio"),
  VISUAL("VI", "Visual"),
  AUDIOMOBILE("AM", "AudioMobile"),
  VISUALMOBILE("VM", "VisualMobile");

  public String getCode() {
    return code;
  }

  public String getType() {
    return type;
  }

  private final String code;
  private final String type;

  ItemType(String code, String type) {
    this.code = code;
    this.type = type;
  }

  private String code() {
    return code;
  }

  private String type() {
    return type;
  }

  @Override
  public int getProductID() {
    return 0;
  }

  @Override
  public void setName(String name) {}

  @Override
  public String getName() {
    return null;
  }

  @Override
  public void setManufacturer(String manufacturer) {}

  @Override
  public String getManufacturer() {
    return null;
  }
}
