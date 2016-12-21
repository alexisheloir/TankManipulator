import java.applet.Applet;
import java.util.Vector;

/**
 * @author Walid
 */
public class Table extends Applet {

  // declare commandQueue as an attribute
  private CommandsQueue cmdQueue = null;

  // declare keyboardListener as an attribute
  private KeyboardListener keyboardListener = null;

  private TankFactory tankFactory = new TankFactory();

  private Vector<Tank> listOfCreatedTanks = new Vector<Tank>(); // list of created tanks

  private int indexOfSelectedTank = -1; // the selected tank index in the tank list to be commanded

  /**
   * Constructor: creates a table (global program)
   */
  public Table() {
    
    // create a tank and insert it into the list of created tanks
    this.listOfCreatedTanks.add(this.tankFactory.createNewTank(Tank.TANK_COLORS.orange));
    System.out.println("length = " + this.listOfCreatedTanks.get(0).getSoundsMap().get("LeftForwardRightStop").getFrameLength());

    // the default selected tank is the last one created
    this.setIndexOfSelectedTank(this.getListOfCreatedTanks().size() - 1);
    System.out.println("IndexOfSelectedTank = " + this.getIndexOfSelectedTank());

    cmdQueue = new CommandsQueue(); // the queue that will store commands, this should be in common between the keyListener and the commandsConsumer

    keyboardListener = new KeyboardListener(cmdQueue, this.getListOfCreatedTanks(), this.getIndexOfSelectedTank()); // to read inputs and store
                                                                                                                    // commands
    addKeyListener(keyboardListener); // this is to read the inputs from keyboard on this Applet

    // create a thread of consumer that will use the same queue of commands
    Thread thread_commandConsumer = new Thread(new CommandConsumer(cmdQueue));

    thread_commandConsumer.start(); // start the consumer thread

    this.setSize(400, 300); // size of the window
    System.out.println("Table class created");
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
   * change the selected tank
   */
  public void changeTankColor(Tank currentSelectedTank) {
    // /nn
  }

  /**
   * @return the listOfCreatedTanks
   */
  public Vector<Tank> getListOfCreatedTanks() {
    return listOfCreatedTanks;
  }

  /**
   * @param listOfCreatedTanks the listOfCreatedTanks to set
   */
  public void setListOfCreatedTanks(Vector<Tank> listOfCreatedTanks) {
    this.listOfCreatedTanks = listOfCreatedTanks;
  }

  /**
   * @return the currentlySelectedTank
   */
  public int getIndexOfSelectedTank() {
    return indexOfSelectedTank;
  }

  /**
   * @param currentlySelectedTank the currentlySelectedTank to set
   */
  public void setIndexOfSelectedTank(int indexOfSelectedTank) {
    this.indexOfSelectedTank = indexOfSelectedTank;
  }

}
