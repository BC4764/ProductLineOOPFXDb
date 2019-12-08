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
   * @param audioSpecification - audio specification of product.
   * @param mediaType - media type of product.
   */
  public AudioPlayer(
      String name, String manufacturer, String audioSpecification, String mediaType) {

    super(name, manufacturer, null);
    this.audioSpecification = audioSpecification;
    this.mediaType = mediaType;
  }

  /**
   * initialize placeholders for audioSpecification and mediaType.
   *
   * @return - prints a String.
   */
  public String toString() {

    return super.toString()
        + "\nSupported Audio Formats: "
        + audioSpecification
        + "\nSupported Playlist Formats: "
        + mediaType;
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
}
