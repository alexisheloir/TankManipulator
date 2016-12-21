/**
 * 
 */

/**
 * @author walid
 */
public class TankGray extends Tank {
  
  /**
   * Constructor of gray tank
   */
  public TankGray(){
    this.setTankColor(TANK_COLORS.gray);
    this.initializeSoundsFilesMap();
  }
 
  public void initializeSoundsFilesMap() {
    this.soundsMap.put("fire", this.loadFileIntoMemory("Sounds/grayTankSoundFiles/firegraytankflip.wav"));
    this.soundsMap.put("LeftBackwardRightBackward", this.loadFileIntoMemory("Sounds/grayTankSoundFiles/lbrbgraytankflip.wav"));
    this.soundsMap.put("LeftBackwardRightForward", this.loadFileIntoMemory("Sounds/grayTankSoundFiles/lbrfgraytankflip.wav"));
    this.soundsMap.put("LeftBackwardRightStop", this.loadFileIntoMemory("Sounds/grayTankSoundFiles/lbrsgraytankflip.wav"));
    this.soundsMap.put("LeftForwardRightBackward", this.loadFileIntoMemory("Sounds/grayTankSoundFiles/lfrbgraytankflip.wav"));
    this.soundsMap.put("LeftForwardRightForward", this.loadFileIntoMemory("Sounds/grayTankSoundFiles/lfrfgraytankflip.wav"));
    this.soundsMap.put("LeftForwardRightStop", this.loadFileIntoMemory("Sounds/grayTankSoundFiles/lfrsgraytankflip.wav"));
    this.soundsMap.put("LeftStopRightBackward", this.loadFileIntoMemory("Sounds/grayTankSoundFiles/lsrbgraytankflip.wav"));
    this.soundsMap.put("LeftStopRightForward", this.loadFileIntoMemory("Sounds/grayTankSoundFiles/lsrfgraytankflip.wav"));
    this.soundsMap.put("LeftStopRightStop", this.loadFileIntoMemory("Sounds/grayTankSoundFiles/lsrsgraytankflip.wav"));
  }
  
  
}