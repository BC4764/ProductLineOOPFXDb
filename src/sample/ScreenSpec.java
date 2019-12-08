package sample;

/**
 * Interface with getters and setters
 *
 * @author - Benjamin Cano
 */
public interface ScreenSpec {

  /**
   * get the resolution.
   *
   * @return null.
   */
  String getResolution();

  /**
   * get refresh rate.
   *
   * @return null.
   */
  int getRefreshRate();

  /**
   * get response rate.
   *
   * @return null.
   */
  int getResponseTime();

  /**
   * set resolution.
   *
   * @param resolution - resolution.
   */
  void setResolution(String resolution);

  /**
   * set refresh rate.
   *
   * @param refreshRate - refresh rate.
   */
  void setRefreshRate(int refreshRate);

  /**
   * set response rate.
   *
   * @param responseTime - response time.
   */
  void setResponseTime(int responseTime);
}
