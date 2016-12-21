import java.util.Vector;

public class CommandsQueue {

  private Vector<Command> commandsQueue = new Vector<Command>();    //the queue where commands will be stored

  /**
   * Constructor
   */
  public CommandsQueue() {
    System.out.println("CommandsQueue class has been created");
  }

  /**
   * a method that adds a command at the end of the queue of commands to be executed
   * 
   * @param cmd the command to be stored
   */
  public void enfilerCmd(Command cmd) {
    this.getCommandsQueue().add(cmd); // get the commands queue and then add an element at the end of it
    System.out.println("taille apr�s enfilement: " + this.getCommandsQueue().size());
  }

  /**
   * a method that removes the first command from the beginning of the queue (FIFO policy)
   */
  public void defilerCmd() {
    this.getCommandsQueue().removeElementAt(0);
    System.out.println("size after defilerCmd = " + this.getCommandsQueue().size());
  }

  /**
   * @return the commandsQueue
   */
  public Vector<Command> getCommandsQueue() {
    return commandsQueue;
  }

  /**
   * @param commandsQueue the commandsQueue to set
   */
  public void setCommandsQueue(Vector<Command> commandsQueue) {
    this.commandsQueue = commandsQueue;
  }

  /**
   * create a command with customized timestamp
   * 
   * @param commandCode the code of the pressed button <=> the action to be done
   * @param selectedTank the tank that the command will be sent to
   * @param customTimestamp the custom timestamp of the command
   * @return {@link Command} the created command
   */
  public static Command createCommand(int commandCode, Tank selectedTank, long customTimestamp) {
    return new Command(commandCode, selectedTank, customTimestamp);
  }

  /**
   * create a command with default timestamp (defined in Command class)
   * 
   * @param commandCode the code of the pressed button <=> the action to be done
   * @param selectedTank the tank that the command will be sent to
   * @return {@link Command}the created command
   */
  public static Command createCommand(int commandCode, Tank selectedTank) {
    return new Command(commandCode, selectedTank);
  }
}
