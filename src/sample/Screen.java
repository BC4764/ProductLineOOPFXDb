package sample;

public class Screen implements ScreenSpec {

  private final String getResolution;
  private final int getRefreshRate;
  private final int getResponseTime;

  public Screen(String s, int i, int i1) {
    this.getResolution = s;
    this.getRefreshRate = i;
    this.getResponseTime = i1;
  }

  public String getResolution() {
    return getResolution;
  }

  public int getRefreshRate() {
    return getRefreshRate;
  }

  public int getResponseTime() {
    return getResponseTime;
  }

  public String toString() {

    return ("Screen:"
        + "\nResolution: "
        + getResolution
        + "\nRefresh rate: "
        + getRefreshRate
        + "\nResponse time: "
        + getResponseTime);
  }
}

