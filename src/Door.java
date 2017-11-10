/**
 * Door Class<br>
 * <p>
 * This represents a door for the simulation.
 * <p>
 * Contains a isWinner and picked value.
 * <br> <br>
 * Created: <br>
 * [11/7/17], [zachleblanc]<br>
 * Modifications: <br>
 *
 * @author [zachleblanc]
 * @version [11/7/17]
 */
public class Door {
    // State: instance variables and shared class variables go here.
    private boolean isWinner;
    private boolean picked;

    // Constructors

    /**
     * Constructs a new object of this class.
     *
     * @param isWinner true if the prize is behind this door.
     *                 false if there is nothing behind door.
     */
    public Door(boolean isWinner) {
        // initialise instance variables
        this.isWinner = isWinner;
        this.picked = false;
    }

    // Methods

    /**
     * Returns whether this door is a winner.
     * @return winner or not
     */
    public boolean getIsWinner() {
        return isWinner;
    }

    /**
     * Sets the whether this door is a winner.
     * Not really necessary because of constructor but whatever. (At least
     * not for this simulation)
     * @param winner boolean if you want this door to be a winner.
     */
    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    /**
     * Returns whether this card was picked by the user or not.
     * @return picked or not.
     */
    public boolean isPicked() {
        return picked;
    }

    /**
     * Sets the value of picked if the card was picked by the user or not.
     * @param picked picked or not.
     */
    public void setPicked(boolean picked) {
        this.picked = picked;
    }
}

