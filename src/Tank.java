import java.io.File;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

/**
 * @author walid
 */
public abstract class Tank implements ITank {

  // *************************
  // **     ATTRIBUTES      **
  // *************************
  
  // available tank colors
  static enum TANK_COLORS {
    orange, green, blue, gray
  };

  // the tank color
  private TANK_COLORS tankColor = null;

  // this is where the specific tank sounds are gonna be stored in RAM and mapped with keys
  protected HashMap<String, Clip> soundsMap = new HashMap<String, Clip>();

  // *********************
  // **     METHODS     ** 
  // *********************
  public abstract void initializeSoundsFilesMap();

  public void goForward() {
    this.playSoundFromRam(this.getSoundsMap().get("LeftForwardRightForward"));
  }

  public void goBackward() {
    this.playSoundFromRam(this.getSoundsMap().get("LeftBackwardRightBackward"));
  }

  public void leftForward() {
    this.playSoundFromRam(this.getSoundsMap().get("LeftForwardRightStop"));
  }

  public void rightForward() {
    this.playSoundFromRam(this.getSoundsMap().get("LeftStopRightForward"));
  }

  public void leftBackward() {
    this.playSoundFromRam(this.getSoundsMap().get("LeftBackwardRightStop"));
  }

  public void rightBackward() {
    this.playSoundFromRam(this.getSoundsMap().get("LeftStopRightBackward"));
  }

  public void selfRotationClockwise() {
    this.playSoundFromRam(this.getSoundsMap().get("LeftForwardRightBackward"));
  }

  public void selfRotationAntiClockwise() {
    this.playSoundFromRam(this.getSoundsMap().get("LeftBackwardRightForward"));
  }

  public void stop() {
    this.playSoundFromRam(this.getSoundsMap().get("LeftStopRightStop"));
  }

  public Clip loadFileIntoMemory(String fileUrl) {
    Clip clip = null;
    try {
      File soundFile = new File(fileUrl);

      AudioInputStream sound = AudioSystem.getAudioInputStream(soundFile);

      // load the sound into main memory as a Clip
      DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
      clip = (Clip) AudioSystem.getLine(info);

      clip.open(sound);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return clip;
  }

  public void playSoundFromRam(final Clip clip) {
    try {
      clip.setFramePosition(0); // reset the start point of playing
      clip.start(); //play the audio clip

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * @return the tankColor
   */
  public TANK_COLORS getTankColor() {
    return tankColor;
  }

  /**
   * @param tankColor the tankColor to set
   */
  public void setTankColor(TANK_COLORS tankColor) {
    this.tankColor = tankColor;
  }

  /**
   * @return the soundsMap
   */
  public HashMap<String, Clip> getSoundsMap() {
    return soundsMap;
  }

  /**
   * @param soundsMap the soundsMap to set
   */
  public void setSoundsMap(HashMap<String, Clip> soundsMap) {
    this.soundsMap = soundsMap;
  }

}