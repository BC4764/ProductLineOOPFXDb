package sample;

import javafx.scene.control.ChoiceBox;

public enum ItemType {
  AUDIO("AU"),
  VISUAL("VI"),
  AUDIO_MOBILE("AM"),
  VISUAL_MOBILE("VM");

  public final String values;

  ItemType(String value) {
    values = value;
  }

  public String getValues() {
    return this.values;
  }
}
