/**
 * @author Walid
 */
public class TankOrange extends Tank {

  /**
   * Constructor of orange tank
   */
  public TankOrange() {
    this.setTankColor(TANK_COLORS.orange);
    this.initializeSoundsFilesMap();
  }


  /**
   * Associates each sound file (value) with a key in the HashMap
   */
  public void initializeSoundsFilesMap() {
    this.soundsMap.put("fire", this.loadFileIntoMemory("Sounds/orangeTankSoundFiles/fireorangetankflip.wav"));
    this.soundsMap.put("LeftBackwardRightBackward", this.loadFileIntoMemory("Sounds/orangeTankSoundFiles/lbrborangetankflip.wav"));
    this.soundsMap.put("LeftBackwardRightForward", this.loadFileIntoMemory("Sounds/orangeTankSoundFiles/lbrforangetankflip.wav"));
    this.soundsMap.put("LeftBackwardRightStop", this.loadFileIntoMemory("Sounds/orangeTankSoundFiles/lbrsorangetankflip.wav"));
    this.soundsMap.put("LeftForwardRightBackward", this.loadFileIntoMemory("Sounds/orangeTankSoundFiles/lfrborangetankflip.wav"));
    this.soundsMap.put("LeftForwardRightForward", this.loadFileIntoMemory("Sounds/orangeTankSoundFiles/lfrforangetankflip.wav"));
    this.soundsMap.put("LeftForwardRightStop", this.loadFileIntoMemory("Sounds/orangeTankSoundFiles/lfrsorangetankflip.wav"));
    this.soundsMap.put("LeftStopRightBackward", this.loadFileIntoMemory("Sounds/orangeTankSoundFiles/lsrborangetankflip.wav"));
    this.soundsMap.put("LeftStopRightForward", this.loadFileIntoMemory("Sounds/orangeTankSoundFiles/lsrforangetankflip.wav"));
    this.soundsMap.put("LeftStopRightStop", this.loadFileIntoMemory("Sounds/orangeTankSoundFiles/lsrsorangetankflip.wav"));
  }

}