

public class TankFactory {
  
  /** Constructor */
  public TankFactory() {

  }
  
  /**
   * Create a new tank of color "color"
   * @param color the color of tank
   * @return the created tank
   */
  public Tank createNewTank(Tank.TANK_COLORS color){
    Tank tank = null;
    switch(color){
    case blue:
      tank = new TankBlue();
      break;
    case gray:
      tank = new TankGray();
      break;
    case green:
      tank = new TankGreen();
      break;
    case orange:
      tank = new TankOrange();
      break;
    default:
      break;
    }
    
    return tank;
  } 
}
