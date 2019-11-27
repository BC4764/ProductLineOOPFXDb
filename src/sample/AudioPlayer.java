package sample;

/**
 * Adds audio specifications and media types of the Product produced which is inherited from
 * product. Implements the interface MultimediaControl.
 *
 * @author - Benjamin Cano
 */
public class AudioPlayer extends Product implements MultimediaControl {

  private String audioSpecification;
  private String mediaType;

  /**
   * Constructor that sets values to the variables which inherits from the product class.
   *
   * @param name - name of product
   * @param manufacturer - manufacturer of product
   * @param type - type of item, inherited.
   * @param audioSpecification - audio specification of product.
   * @param mediaType - media type of product.
   */
  public AudioPlayer(
      String name,
      String manufacturer,
      ItemType type,
      String audioSpecification,
      String mediaType) {
    super(name, manufacturer, type);
    this.audioSpecification = audioSpecification;
    this.mediaType = mediaType;
  }

  /**
   * initialize placeholders for audioSpecification and mediaType.
   *
   * @return - prints a String.
   */
  public String toString() {
    String spec = "Supported Audio Formats: " + this.audioSpecification + '\n';
    String media = "Supported Playlist Formats: " + this.mediaType;
    return super.toString() + spec + media;
  }

  /** prints "playing" when called to play. */
  public void play() {
    System.out.println("Playing");
  }

  /** prints "stopping" when called to stop. */
  public void stop() {
    System.out.println("Stopping");
  }

  /** prints "next" when called to next. */
  public void next() {
    System.out.println("Next");
  }

  /** prints "previous" when called to go previous. */
  public void previous() {
    System.out.println("Previous");
  }

  /**
   * get audio specification.
   *
   * @return - audioSpecification
   */
  public String getAudioSpecification() { // inspection code warning: Method is never used.
    return audioSpecification;
  }

  /**
   * set audio specification.
   *
   * @param audioSpecification - audio specification.
   */
  public void setAudioSpecification(
      String audioSpecification) { // inspection code warning: Method owner class is never
    // instantiated.
    this.audioSpecification = audioSpecification;
  }

  /**
   * get media type.
   *
   * @return - mediaType.
   */
  public String
      getMediaType() { // inspection code warning: Method owner class is never instantiated.
    return mediaType;
  }

  /**
   * set media type.
   *
   * @param mediaType - media type.
   */
  public void setMediaType(
      String mediaType) { // inspection code warning: Method owner class is never instantiated.
    this.mediaType = mediaType;
  }
}
