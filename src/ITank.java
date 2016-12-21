import javax.sound.sampled.Clip;

/**
 * @author Walid
 */

public interface ITank {

  /**
   * Initialize the hashMap of sounds (commands) files of the tank, the initialization depends on the tank color.
   */
  public void initializeSoundsFilesMap();

  /**
   * Move the tank forward, both caterpillar will turn forward
   */
  public void goForward();

  /**
   * Move the tank backward, both caterpillar will turn backward
   */
  public void goBackward();

  /**
   * Turn the left tank caterpillar forward, the right one will be stopped
   */
  public void leftForward();

  /**
   * Turn the right tank caterpillar forward, the left one will be stopped
   */
  public void rightForward();

  /**
   * Turn the left tank caterpillar backward, the right one will be stopped
   */
  public void leftBackward();

  /**
   * Turn the right tank caterpillar backward, the left one will be stopped
   */
  public void rightBackward();

  /**
   * this method allows a self rotation of the tank CLOCKWISE
   */
  public void selfRotationClockwise();

  /**
   * this method allows a self rotation of the tank ANTI-CLOCKWISE
   */
  public void selfRotationAntiClockwise();

  /**
   * Stop the tank
   */
  public void stop();

  /**
   * Load an audio file from the hard disk drive into the RAM
   * 
   * @param fileUrl the URL of the file on the HDD to be loaded, both of absolute path and relative path works.
   * @return The audio input stream where the file is stored in the main memory
   */
  public Clip loadFileIntoMemory(String fileUrl);

  /**
   * Play a sound track stored in the main memory. It will transmit the signal (command) to the tank.
   * 
   * @param soundAudioInputStream the relative audio input stream of the file to be played. It is stored in the main memory and not in HDD
   */
  public void playSoundFromRam(final Clip clip);

}
