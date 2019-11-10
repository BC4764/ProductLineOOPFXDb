package sample;

@SuppressWarnings("ALL")
public class AudioPlayer extends Product implements MultimediaControl {
  private static final ItemType type = ItemType.AUDIO;
  final String supportedAudioFormats;
  final String supportedPlaylistFormats;

  public AudioPlayer(
      String manufacturer,
      String name,
      String supportedAudioFormats,
      String supportedPlaylistFormats) {

    super(manufacturer, name, type);
    this.supportedAudioFormats = supportedAudioFormats;
    this.supportedPlaylistFormats = supportedPlaylistFormats;
  }

  @Override
  public void play() {

    System.out.println("Playing");
  }

  @Override
  public void stop() {

    System.out.println("Stopping");
  }

  @Override
  public void previous() {

    System.out.println("Previous");
  }

  @Override
  public void next() {

    System.out.println("Next");
  }

  public String toString() {
    System.out.print(super.toString());
    return ("\nSupported Audio Formats: "
        + this.supportedAudioFormats
        + " \nSupported Playlist Formats: "
        + this.supportedPlaylistFormats);
  }

  @Override
  public ItemType getType() {
    return null;
  }

  @Override
  public int getProductID() {
    return 0;
  }
}
