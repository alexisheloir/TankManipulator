import java.sql.Timestamp;

public class Command {
  private Timestamp cmdTimestamp; // the command timestamp
  private long defaultTimestamp = 50; // default timestamp is equal 50 milliseconds
  private int commandCode = -1; // -1 means nothing => no command
  private Tank tank; // associated tank

  /**
   * Constructor with default timestamp
   * 
   * @param cmdCode the command code
   * @param selectedTank the tank that will be manipulated by the command
   */
  public Command(int cmdCode, Tank selectedTank) {
    this.setCmdTimestamp(new Timestamp(defaultTimestamp)); // set the default timestamp of any command to
    this.setTank(selectedTank); // set the tank that the command will be sent to
    this.setCommandCode(cmdCode); // set the commandType or code <=> the action to be done
  }

  /**
   * Constructor with custom timestamp to be given as parameter
   * 
   * @param cmdCode the command code
   * @param selectedTank the tank that will be manipulated by the command
   * @param customTimestamp the timestamp of the command in the queue in milliseconds
   */
  public Command(int cmdCode, Tank selectedTank, long customTimestamp) {
    this.setCmdTimestamp(new Timestamp(customTimestamp)); // set the default timestamp of any command to
    this.setTank(selectedTank); // set the tank that the command will be sent to
    this.setCommandCode(cmdCode); // set the commandType or code <=> the action to be done
  }

  /**
   * @return the default Timestamp as defined
   */
  public long getDefaultTimestamp() {
    return defaultTimestamp;
  }

  /** setter of defaultTimestamp */
  public void setDefaultTimestamp(long defaultTimestamp) {
    this.defaultTimestamp = defaultTimestamp;
  }

  /** getter: @return the cmdTimestamp */
  public Timestamp getCmdTimestamp() {
    return cmdTimestamp;
  }

  /** setter: @param cmdTimestamp the cmdTimestamp to set */
  public void setCmdTimestamp(Timestamp cmdTimestamp) {
    this.cmdTimestamp = cmdTimestamp;
  }

  /**
   * getter: @return the commandCode
   */
  public int getCommandCode() {
    return commandCode;
  }

  /**
   * setter: @param commandCode the commandCode to set
   */
  public void setCommandCode(int commandCode) {
    this.commandCode = commandCode;
  }

  /**
   * @return the tank
   */
  public Tank getTank() {
    return tank;
  }

  /**
   * @param tank the tank to set
   */
  public void setTank(Tank tank) {
    this.tank = tank;
  }

}