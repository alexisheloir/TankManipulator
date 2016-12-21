import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

public class KeyboardListener implements KeyListener {

  /** AZ, QS, AS, QZ will be used as commands codes when two keys are pressed */
  private final int AZ = 6590;
  private final int QS = 8183;
  private final int AS = 6583;
  private final int QZ = 8190;
  private final int StopKeyCode = KeyEvent.VK_H;

  private CommandsQueue cmdQueue = null; // the command queue that will be used to store commands
  private final Set<Integer> pressedKey = new HashSet<Integer>(); // temporarily stores the pressed keys codes

  private Vector<Tank> TanksList = null;
  private int selectedTankIndex;

  /**
   * Constructor of KeyboardListener
   * 
   * @param cmdQueue the commandQueue instance that will contain all commands waiting to be executed
   * @param list_tanks the list containing all created tanks
   * @param selectedTankIndex the selected tank index in the list of tanks to be manipulated
   */
  public KeyboardListener(CommandsQueue cmdQueue, Vector<Tank> list_tanks, int selectedTankIndex) {
    this.setCmdQueue(cmdQueue);
    this.setSelectedTankIndex(selectedTankIndex);
    this.setTanksList(list_tanks);
    System.out.println("KeyboardListener class has been created");
  }

  /**
   * This method will store commands in a queue, it works in synchronization with the one which executes commands.
   * 
   * @param commandCode the code of the pressed button
   * @param tankColorCode the selected tank to be manipulated by this command
   */
  public synchronized void enfilerCommand(int commandCode, Tank tank) {
    Command newCommand = CommandsQueue.createCommand(commandCode, tank);
    cmdQueue.enfilerCmd(newCommand);
    System.out.println("One command has been stored. Size of the queue is: " + cmdQueue.getCommandsQueue().size());

    for (int i = 0; i < this.getCmdQueue().getCommandsQueue().size(); i++) {
      System.out.println("queue = " + i + " = " + this.getCmdQueue().getCommandsQueue().get(i).getCommandCode());
    }
  }

  /**
   * @return the commandsQueue object
   */
  public CommandsQueue getCmdQueue() {
    return cmdQueue;
  }

  /**
   * @param cmdQueue the commandsQueue to set
   */
  public void setCmdQueue(CommandsQueue cmdQueue) {
    this.cmdQueue = cmdQueue;
  }

  /**
   * (non-Javadoc)
   * 
   * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
   */
  public synchronized void keyPressed(KeyEvent e) {
    try {
      pressedKey.add(e.getKeyCode());

      if (pressedKey.size() > 1) {
        int commandeCode = -1;
        // More than one key is currently pressed.
        System.out.println("More than one key is currently pressed...");
        System.out.println("pressedKeys = " + pressedKey);

        // verify which keys are pressed
        if (this.verifyKeyIsPressed(KeyEvent.VK_A, pressedKey) && this.verifyKeyIsPressed(KeyEvent.VK_Z, pressedKey)) {
          commandeCode = AZ; // concatenated codes of both A and Z
        } else if (this.verifyKeyIsPressed(KeyEvent.VK_A, pressedKey) && this.verifyKeyIsPressed(KeyEvent.VK_S, pressedKey)) {
          commandeCode = AS; // concatenated codes of both A and S
        } else if (this.verifyKeyIsPressed(KeyEvent.VK_Q, pressedKey) && this.verifyKeyIsPressed(KeyEvent.VK_S, pressedKey)) {
          commandeCode = QS; // concatenated codes of both Q and S
        } else if (this.verifyKeyIsPressed(KeyEvent.VK_Q, pressedKey) && this.verifyKeyIsPressed(KeyEvent.VK_Z, pressedKey)) {
          commandeCode = QZ; // concatenated codes of both Q and Z
        }

        else {
          // There doesn't exist anything else => do nothing
        }
        // insert the command in the queue along with the concerned tank
        this.enfilerCommand(commandeCode, this.getTanksList().get(this.getSelectedTankIndex()));

      } else {
        System.out.println("ONLY one key is currently pressed...");

        // verify which key is pressed, if it is one of the commandment then
        // store it, else ignore it
        if ((e.getKeyCode() == KeyEvent.VK_A) || (e.getKeyCode() == KeyEvent.VK_Z) || (e.getKeyCode() == KeyEvent.VK_S)
            || (e.getKeyCode() == KeyEvent.VK_Q) || (e.getKeyCode() == KeyEvent.VK_H) || (e.getKeyCode() == KeyEvent.VK_SPACE)) {
          // if it is one the above buttons then we store it
          this.enfilerCommand(e.getKeyCode(), this.getTanksList().get(this.getSelectedTankIndex()));
        } else {
          // there is nothing to do else, just ignore it
        }
      }
    } catch (Exception e1) {
      e1.printStackTrace();
    }
  }

  /**
   * (non-Javadoc)
   * 
   * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
   */
  public synchronized void keyReleased(KeyEvent e) {
    try {
      pressedKey.remove(e.getKeyCode());

      // **if there is no key pressed then we should stop <=> stop button is
      // pressed
      if (!this.verifyKeyIsPressed(KeyEvent.VK_A, pressedKey) && !this.verifyKeyIsPressed(KeyEvent.VK_Q, pressedKey)
          && !this.verifyKeyIsPressed(KeyEvent.VK_Z, pressedKey) && !this.verifyKeyIsPressed(KeyEvent.VK_S, pressedKey)) {

         //this.enfilerCommand(StopKeyCode, this.getTanksList().get(this.getSelectedTankIndex()));
      }
    } catch (Exception e1) {
      e1.printStackTrace();
    }
  }

  /**
   * (non-Javadoc)
   * 
   * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
   */
  public synchronized void keyTyped(KeyEvent arg0) {

  }

  /**
   * Verify that a key among a given set is pressed
   * 
   * @param keyCode the code of the key to be verified whether it is pressed or not.
   * @param setToVerifyIn the set of codes containing to verify in it.
   * @return returns true if the key or button is pressed, false else.
   */
  private boolean verifyKeyIsPressed(int keyCode, Set setToVerifyIn) {
    boolean result = false;

    Iterator<Integer> iterator = setToVerifyIn.iterator();
    while (iterator.hasNext()) {
      Integer setElement = iterator.next();
      if (setElement == keyCode) {
        result = true;
      }
    }
    return result;
  }

  /**
   * @return the selectedTankIndex
   */
  public int getSelectedTankIndex() {
    return selectedTankIndex;
  }

  /**
   * @param selectedTankIndex the selectedTankIndex to set
   */
  public void setSelectedTankIndex(int selectedTankIndex) {
    this.selectedTankIndex = selectedTankIndex;
  }

  /**
   * @return the tanksList
   */
  public Vector<Tank> getTanksList() {
    return TanksList;
  }

  /**
   * @param tanksList the tanksList to set
   */
  public void setTanksList(Vector<Tank> tanksList) {
    TanksList = tanksList;
  }

}
