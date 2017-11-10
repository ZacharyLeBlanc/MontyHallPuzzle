import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * MontyHallPuzzle<br>
 * <p>
 *     This is the Monty Hall simulation.
 * <p>
 * The Monty Hall Three-Door Puzzle Suppose you are a game show contestant.
 * You have a chance to win a large prize. You are asked to select one of
 * three doors to open; the large prize is behind one of the three doors and
 * the other two doors are losers. Once you select a door, the game show host,
 * who knows what is behind each door, does the following. First, whether or not
 * you selected the winning door, he opens one of the other two doors that he
 * knows is a losing door (selecting at random if both are losing doors). Then
 * he asks you whether you would like to switch doors. Which strategy should
 * you use? Should you change doors or keep your original selection, or does it
 * not matter?
 * Courtesy of of Dr. Howser's instructions.
 * <br> <br>
 * Created: <br>
 * [11/7/17], [zachleblanc]<br>
 * Modifications: <br>
 *
 * @author [zachleblanc]
 * @version [11/7/17]
 */
public class MontyHallSim {
    // State: instance variables and shared class variables go here.
    private ArrayList<Door> doors = new ArrayList<>();
    private Random rand = new Random();
    private boolean didSwitch;
    private int switchCounter;
    private int stayedCounter;

    // Constructors

    /**
     * Sets up the simulation.
     */
    public MontyHallSim() {
        this.didSwitch = false;
        this.switchCounter = 0;
        this.stayedCounter = 0;
    }

    // Methods

    /**
     * This is the main method of the class that runs the simulation of the
     * Monty Hall puzzle.
     * @param numOfIterations number of times you want to run the simulation.
     */
    public void simulate(int numOfIterations) {
        for (int i = 0; i < numOfIterations; i++) {
            //Clear the arraylist for a new game then make 3 new doors and add them
            //to the arraylist and shuffles them.
            newGame();

            // Select a door by random either 0, 1, or 2
            int numberPicked = rand.nextInt(2);
            doors.get(numberPicked).setPicked(true);

            removeDoor(numberPicked);
            switchDoors();
            isWinner();
        }
    }

    /**
     * Helper method to print the doors.
     */
    private void printDoors() {
        for (Door d : doors) {
            System.out.println(d.isPicked() + " " + d.getIsWinner());
        }
    }

    /**
     * Creates a new game. Resets some of the variables. Clears the arraylist,
     * creates 3 new doors and adds them to the arraylist then shuffles them.
     */
    private void newGame() {
        doors.clear();
        didSwitch = false;

        //Create 3 random doors. 1 is a winner.
        Door door1 = new Door(true);
        Door door2 = new Door(false);
        Door door3 = new Door(false);

        // Add doors to arraylist
        doors.add(door1);
        doors.add(door2);
        doors.add(door3);

        // Shuffle the doors
        Collections.shuffle(doors);
    }

    /**
     * This method removes one of the doors after you pick the door.
     * @param numberPicked index of the door picked
     */
    private void removeDoor(int numberPicked) {
        // if you have winner remove either of other doors
        // if you pick loser remove one that is not winner
        if (doors.get(numberPicked).getIsWinner()) {
            for (Door d: doors) {
                if (!d.isPicked()) {
                    doors.remove(d);
                    break;
                }
            }
        } else {
            for (Door d : doors) {
                if (!d.isPicked() && !d.getIsWinner()) {
                    doors.remove(d);
                    break;
                }
            }
        }
    }

    /**
     * Method to switch the doors if the user desires. Switched means the user
     * changed which door he picks.
     */
    private void switchDoors() {
        // Pick whether you want to keep or switch your doors
        boolean switched = rand.nextBoolean();
        if (switched) {
            for (Door d : doors) {
                d.setPicked(!d.isPicked());
                didSwitch = true;
            }
        }
    }

    /**
     * This method checks to see if you won and increments the counter
     * depending on what was the strategy that won.
     */
    private void isWinner() {
        for (Door d : doors) {
            if (d.getIsWinner() != d.isPicked()) {
                if (didSwitch) {
                    stayedCounter++;
                } else {
                    switchCounter++;
                }
                break;
            } else if (d.getIsWinner() && d.isPicked()) {
                if (didSwitch) {
                    switchCounter++;
                } else {
                    stayedCounter++;
                }
                break;
            }
        }
    }

    /**
     * Gets the value of how many times staying was the right strategy.
     * @return stayed counter
     */
    public int getStayedCounter() {
        return stayedCounter;
    }

    /**
     * Gets the value of how many times switching was the right strategy.
     * @return switched counter
     */
    public int getSwitchCounter() {
        return switchCounter;
    }
}