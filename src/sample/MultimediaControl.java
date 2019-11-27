package sample;

/**
 * an interface that calls methods.
 *
 * @author - Benjamin Cano
 */
interface MultimediaControl {
  /** A method to play. */
  void play();

  /** A method to stop. */
  void stop();

  /** A method to go previous. */
  void previous();

  /** A method to go next. */
  void next();
}
