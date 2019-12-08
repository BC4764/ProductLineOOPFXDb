package sample;

/**
 * Class containing the variables for the screen, containing getters and setter methods the for
 * corresponding variables and a toString that returns the value of each variable when it is called
 * while implementing the class ScreenSpec.
 *
 * @author - Benjamin Cano
 */
public class Screen implements ScreenSpec {

  private String resolution;
  private int refreshRate;
  private int responseTime;

  /**
   * Constructor that sets values to the variables.
   *
   * @param resolution - screen resolution.
   * @param refreshRate - screen refresh rate.
   * @param responseTime - screen response time.
   */
  Screen(String resolution, int refreshRate, int responseTime) {
    this.resolution = resolution;
    this.refreshRate = refreshRate;
    this.responseTime = responseTime;
  }

  /**
   * Method that will return a String once called to it.
   *
   * @return - A string.
   */
  public String toString() {
    return "Screen:"
        + "\n"
        + "Resolution: "
        + resolution
        + "\n"
        + "Refresh rate: "
        + refreshRate
        + "\n"
        + "Response time: "
        + responseTime;
  }

  /**
   * get the screen's resolution.
   *
   * @return resolution.
   */
  @Override
  public String getResolution() {
    return null;
  }

  /**
   * set the screen's resolution.
   *
   * @param resolution - screen resolution.
   */
  public void setResolution(String resolution) {
    this.resolution = resolution;
  }

  /**
   * get screen's refresh rate.
   *
   * @return - refresh rate.
   */
  public int getRefreshRate() {
    return 0;
  }

  /**
   * set screen's refresh rate.
   *
   * @param refreshRate - refresh rate.
   */
  public void setRefreshRate(int refreshRate) {
    this.refreshRate = refreshRate;
  }

  /**
   * get screen's response time.
   *
   * @return response time.
   */
  public int getResponseTime() {
    return 0;
  }

  /**
   * set screen's response time.
   *
   * @param responseTime - response time.
   */
  public void setResponseTime(int responseTime) {
    this.responseTime = responseTime;
  }
}
