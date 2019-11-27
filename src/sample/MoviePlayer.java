package sample;

/**
 * MoviePlayer provides info about the type of screen and monitor used. Class
 * extends Product and implements MultimediaControl class.
 *
 * @author - Benjamin Cano
 */
public class MoviePlayer extends Product implements MultimediaControl {
  // screen and monitorType variables
  private Screen screen;
  private MonitorType monitorType;

  /**
   * Constructor for MoviePlayer.
   *
   * @param name - name of product.
   * @param manufacturer - manufacturer of product.
   * @param screen - screen of product.
   * @param monitorType - monitor type of product.
   */
  public MoviePlayer(
      String name,
      String manufacturer,
      Screen screen,
      MonitorType monitorType) {
    super(name, manufacturer, ItemType.Visual);
    this.screen = screen;
    setMonitorType(monitorType);
  }

  /**
   * Method that adds variables to String.
   *
   * @return - a String.
   */
  public String toString() {
    return super.toString() + "\n" + screen + "\n" + "Monitor Type: " + monitorType;
  }

  /** prints out "playing movie" when method called. */
  public void play() {
    System.out.println("Playing movie");
  }

  /** prints out "stopping movie" when method is called. */
  @Override
  public void stop() {
    System.out.println("Stopping movie");
  }

  /** prints out "previous movie" when method is called. */
  public void previous() {
    System.out.println("Previous movie");
  }

  /** prints out "next movie" when method is called. */
  public void next() {
    System.out.println("Next movie");
  }

  /**
   * gets Screen type.
   *
   * @return screen.
   */
  public Screen getScreen() {
    return screen;
  }

  /**
   * sets screen.
   *
   * @param screen .
   */
  public void setScreen(Screen screen) {
    this.screen = screen;
  }

  /**
   * gets monitor type.
   *
   * @return monitorType.
   */
  public MonitorType
      getMonitorType() {
    return monitorType;
  }

  /**
   * sets monitorType.
   *
   * @param monitorType .
   */
  private void setMonitorType(MonitorType monitorType) {
    this.monitorType = monitorType;
  }
}
