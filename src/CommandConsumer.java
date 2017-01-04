import java.awt.event.KeyEvent;

/**
 * @author Walid
 */
public class CommandConsumer extends Thread {

  private CommandsQueue cmdQueue = null; // the command queue that will be used to read commands and execute them


  /**
   * Constructor
   * 
   * @param cmd_Queue the command queue object that contains the queue of commands to be executed
   */
  public CommandConsumer(CommandsQueue cmd_Queue) {
    this.setCmdQueue(cmd_Queue);

    System.out.println("CommandConsumer class has been created");
  }

  /**
   * remove the command from the command queue then execute it
   */
  public synchronized void defilerCommand() {
    // execute the command
    this.executerCommand(cmdQueue.getCommandsQueue().get(0));

    // call the method in the queue of commands to
    cmdQueue.defilerCmd();

    System.out.println("Une commande vient d'etre defilee et excutee. Size of the queue is: " + this.getCmdQueue().getCommandsQueue().size());

  }

  /**
   * the method that will send the signal to the tank in order to move
   * 
   * @param cmd the command to be executed
   */
  public void executerCommand(Command cmd) {

    /* depending on the pressed key, the command will play a sound file */
    System.out.println("executing cmd, tank color " + cmd.getTank().getTankColor().toString() + " and command code = " + cmd.getCommandCode());

    switch (cmd.getCommandCode()) {

    case KeyEvent.VK_A:
      /** left forward */
      cmd.getTank().leftForward(); // call the method leftforward of the tank, it knows the color of the tank
      break;

    case KeyEvent.VK_Q: // left backward
      cmd.getTank().leftBackward();
      break;

    case KeyEvent.VK_Z: // right forward
      cmd.getTank().rightForward();
      break;

    case KeyEvent.VK_S: // right backward
      cmd.getTank().rightBackward();
      break;

    case KeyboardListener.AZ: // move forward
      cmd.getTank().goForward();
      break;

    case KeyboardListener.QS: // move backward
      cmd.getTank().goBackward();
      break;

    case KeyboardListener.AS: // self rotation clockwise
      cmd.getTank().selfRotationClockwise();
      break;

    case KeyboardListener.QZ: // self rotation anti-clockwise
      cmd.getTank().selfRotationAntiClockwise();
      break;

    case KeyEvent.VK_H: // stop
      cmd.getTank().stop();
      break;

    case KeyEvent.VK_SPACE:
      /** change the selected color or tank to be commanded */
      // / movements.changeSelectedTank_color(this.getColorsTanks() ,
      // cmd.getTankColor());
      break;
    }
  }

  /**
   * @return the cmdQueue
   */
  public CommandsQueue getCmdQueue() {
    return cmdQueue;
  }

  /**
   * @param cmdQueue the cmdQueue to set
   */
  public void setCmdQueue(CommandsQueue cmdQueue) {
    this.cmdQueue = cmdQueue;
  }

  /**
   * (non-Javadoc)
   * 
   * @see java.lang.Thread#run()
   */
  public void run() {
    // this function has to be running all the time so:
    while (true) {
      // verify if there exist a command in the queue, if so then execute it
      if (this.getCmdQueue().getCommandsQueue().size() > 0) {
        this.defilerCommand();
        // System.out.println("one command has been taken out from the queue and executed!");
      } else {
        // System.out.println("the queue is empty.");
      }
    }
  }

}