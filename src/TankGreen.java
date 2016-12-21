/**
 * 
 */

/**
 * @author walid
 *
 */
public class TankGreen extends Tank {

  /**
   * Constructor of green tank
   */
  public TankGreen(){
    this.setTankColor(TANK_COLORS.green);
    this.initializeSoundsFilesMap();
  }

  public void initializeSoundsFilesMap() {
    this.soundsMap.put("fire", this.loadFileIntoMemory("Sounds/greenTankSoundFiles/firegreentankflip.wav"));
    this.soundsMap.put("LeftBackwardRightBackward", this.loadFileIntoMemory("Sounds/greenTankSoundFiles/lbrbgreentankflip.wav"));
    this.soundsMap.put("LeftBackwardRightForward", this.loadFileIntoMemory("Sounds/greenTankSoundFiles/lbrfgreentankflip.wav"));
    this.soundsMap.put("LeftBackwardRightStop", this.loadFileIntoMemory("Sounds/greenTankSoundFiles/lbrsgreentankflip.wav"));
    this.soundsMap.put("LeftForwardRightBackward", this.loadFileIntoMemory("Sounds/greenTankSoundFiles/lfrbgreentankflip.wav"));
    this.soundsMap.put("LeftForwardRightForward", this.loadFileIntoMemory("Sounds/greenTankSoundFiles/lfrfgreentankflip.wav"));
    this.soundsMap.put("LeftForwardRightStop", this.loadFileIntoMemory("Sounds/greenTankSoundFiles/lfrsgreentankflip.wav"));
    this.soundsMap.put("LeftStopRightBackward", this.loadFileIntoMemory("Sounds/greenTankSoundFiles/lsrbgreentankflip.wav"));
    this.soundsMap.put("LeftStopRightForward", this.loadFileIntoMemory("Sounds/greenTankSoundFiles/lsrfgreentankflip.wav"));
    this.soundsMap.put("LeftStopRightStop", this.loadFileIntoMemory("Sounds/greenTankSoundFiles/lsrsgreentankflip.wav"));
  }
}
