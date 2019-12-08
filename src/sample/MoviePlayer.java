package sample;

/**
 * MoviePlayer provides info about the type of screen and monitor used. Class extends Product and
 * implements MultimediaControl class.
 *
 * @author - Benjamin Cano
 */
public class MoviePlayer extends Product implements MultimediaControl {
  // screen and monitorType variables
  public Screen screen;
  public MonitorType monitorType;

  /**
   * Constructor for MoviePlayer.
   *
   * @param name - name of product.
   * @param manufacturer - manufacturer of product.
   * @param screen - screen of product.
   * @param monitorType - monitor type of product.
   */
  public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
    super(name, manufacturer, null);
    this.screen = screen;
    this.monitorType = monitorType;
  }

  /**
   * Method that adds variables to String.
   *
   * @return - a String.
   */
  @Override
  public String toString() {
    return "Name: "
        + name
        + "\nManufacturer: "
        + manufacturer
        + "\nType: "
        + "VISUAL"
        + "\nScreen: "
        + screen
        + "\nMonitor Type: "
        + monitorType;
  }

  /** prints out "playing movie" when method called. */
  @Override
  public void play() {
    System.out.println("Playing movie");
  }

  /** prints out "stopping movie" when method is called. */
  @Override
  public void stop() {
    System.out.println("Stopping movie");
  }

  /** prints out "previous movie" when method is called. */
  @Override
  public void previous() {
    System.out.println("Previous movie");
  }

  /** prints out "next movie" when method is called. */
  @Override
  public void next() {
    System.out.println("Next movie");
  }
}
