/**
 * @author walid
 *
 */
public class TankBlue extends Tank {
  
  /**
   * Constructor of blue tank
   */
  public TankBlue(){
    this.setTankColor(TANK_COLORS.blue);
    this.initializeSoundsFilesMap();
  }

  public void initializeSoundsFilesMap() {
    this.soundsMap.put("fire", this.loadFileIntoMemory("Sounds/blueTankSoundFiles/firebluetankflip.wav"));
    this.soundsMap.put("LeftBackwardRightBackward", this.loadFileIntoMemory("Sounds/blueTankSoundFiles/lbrbbluetankflip.wav"));
    this.soundsMap.put("LeftBackwardRightForward", this.loadFileIntoMemory("Sounds/blueTankSoundFiles/lbrfbluetankflip.wav"));
    this.soundsMap.put("LeftBackwardRightStop", this.loadFileIntoMemory("Sounds/blueTankSoundFiles/lbrsbluetankflip.wav"));
    this.soundsMap.put("LeftForwardRightBackward", this.loadFileIntoMemory("Sounds/blueTankSoundFiles/lfrbbluetankflip.wav"));
    this.soundsMap.put("LeftForwardRightForward", this.loadFileIntoMemory("Sounds/blueTankSoundFiles/lfrfbluetankflip.wav"));
    this.soundsMap.put("LeftForwardRightStop", this.loadFileIntoMemory("Sounds/blueTankSoundFiles/lfrsbluetankflip.wav"));
    this.soundsMap.put("LeftStopRightBackward", this.loadFileIntoMemory("Sounds/blueTankSoundFiles/lsrbbluetankflip.wav"));
    this.soundsMap.put("LeftStopRightForward", this.loadFileIntoMemory("Sounds/blueTankSoundFiles/lsrfbluetankflip.wav"));
    this.soundsMap.put("LeftStopRightStop", this.loadFileIntoMemory("Sounds/blueTankSoundFiles/lsrsbluetankflip.wav"));
  }
}