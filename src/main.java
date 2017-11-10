// Import statements 

/**
 * MontyHallPuzzle<br>
 * <p>
 * The <code>main</code> class provides a main method
 * for a program that does a simulation of the Monty Hall puzzle.
 * <p>
 *     More useful information in the MontyHallSim class.
 * <br> <br>
 * Created: <br>
 * [11/07/2017], [zachleblanc]<br>
 * Modifications: <br>
 *
 * @author [zachleblanc]
 * @version [11/7/17]
 */
public class main {
    public static void main(String[] args) {
       MontyHallSim g = new MontyHallSim();
       g.simulate(1000000);
       System.out.println("Stayed :" + g.getStayedCounter());
       System.out.println("Switched :" + g.getSwitchCounter());
    }
}
