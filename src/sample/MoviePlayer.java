package sample;

public class MoviePlayer extends Product implements MultimediaControl {

  private final Screen newScreen;
  private final MonitorType monitorType;
  private static final ItemType type = ItemType.VISUAL;

  public MoviePlayer(String name, String manufacturer, Screen newScreen, MonitorType monitorType) {
    super(name, manufacturer, type);
    this.newScreen = newScreen;
    this.monitorType = monitorType;
  }

  @Override
  public void play() {

    System.out.println("Playing movie");
  }

  @Override
  public void stop() {

    System.out.println("Stopping movie");
  }

  @Override
  public void previous() {

    System.out.println("Previous movie");
  }

  @Override
  public void next() {

    System.out.println("Next movie");
  }

  public String toString() {
    System.out.print(super.toString());
    return (newScreen.toString() + "\nMonitor Type: " + monitorType.toString());
  }
  }