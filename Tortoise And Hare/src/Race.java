import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class Race extends JFrame {
    private ArrayList<Racer> racerList; // racers stored in ArrayList
    private static Race app;
    private final int FIRST_RACER = 50;
    private int finishX; // location of finish line, dependent on window width
    private boolean raceIsOn = false;
    private RacePanel racePanel;

    /**
     * Constructor instantiates list to track racers sets up GUI components
     */
    public Race() {
        super("The Tortoise & The Hare!");
        Container c = getContentPane();
        racePanel = new RacePanel();
        c.add(racePanel, BorderLayout.CENTER);

        racerList = new ArrayList<Racer>();
        setSize(400, 400);
        setVisible(true);
    }

    /**
     * prepareToRace method
     * uses a dialog box to prompt user for racer types and
     * to start the race
     * racer types are	't' or 'T' for Tortoise,
     * 						'h' or 'H' for Hare
     * 's' or 'S' will start the race
     */
    private void prepareToRace() {
        int yPos = FIRST_RACER; // y position of first racer
        final int START_LINE = 40; // x position of start of race
        final int RACER_SPACE = 50; // spacing between racers
        char input;

        input = getRacer(); // get input from user

        while (input != 's' && input != 'S') {
            switch (input) {

                case ('t'):

                case ('T'):

                    Tortoise t = new Tortoise("Tortoise1", START_LINE, yPos);

                    racerList.add(t);

                    yPos += RACER_SPACE;

                    break;

                case ('h'):

                case ('H'):

                    Hare h = new Hare("Hare1", START_LINE, yPos);

                    racerList.add(h);

                    yPos += RACER_SPACE;

                    break;

                case ('p'):

                case ('P'):

                    Pig p = new Pig("Pig1", START_LINE, yPos);

                    racerList.add(p);

                    yPos += RACER_SPACE;

                    break;

                default:

                    JOptionPane.showMessageDialog(this, "Please choose one value from t/T/h/T!!");

            }


            /** end of student code, Part 1 */

            repaint();
            input = getRacer(); // get input from user

        } // end while
    } // end prepareToRace

    private class RacePanel extends JPanel {
        /**
         * paint method
         *
         * @param g
         *           Graphics context draws the finish line; moves and draws
         *           racers
         */

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // draw the finish line
            finishX = getWidth() - 20;
            g.setColor(Color.blue);
            g.drawLine(finishX, 0, finishX, getHeight());

            if (raceIsOn) {
                /* 2. ***** student writes this code
                 * Loop through instance variable ArrayList racerList,
                 * 	which contains Racer object references,
                 * 	calling move, and then draw for each racer.
                 * The API for move is:
                 * 	void move( )
                 * The API for draw is:
                 * 	void draw( Graphics g )
                 * 		where g is the Graphics context passed to
                 * 		the paint method
                 */
                // student code goes here
                for (Racer r : racerList) {

                    r.move();

                    r.draw(g);

                }


                /** end of student code, part 2 */

            } else // display racers before race begins
            {

                /* 3. ***** Student writes this code
                 * Loop through instance variable ArrayList racerList,
                 * 	which contains Racer object references,
                 * 	calling draw for each element. (Do not call move!)
                 * The API for draw is:
                 * 	void draw( Graphics g )
                 * 		where g is the Graphics context
                 * 		passed to this paint method
                 */
                // student code goes here
                for (Racer r : racerList) {

                    r.draw(g);

                }


                /** end of student code, part 3 */
            }
        }
    }

    /**
     * runRace method checks whether any racers have been added to racerList if
     * no racers, exits with message otherwise, runs race, calls repaint to move
     * & draw racers calls reportRaceResults to identify winners(s) calls reset
     * to set up for next race
     * @throws InterruptedException
     */
    public void runRace() throws InterruptedException  {
        if (racerList.size() == 0) {
            JOptionPane.showMessageDialog(this, "The race has no racers. exiting",
                    "No Racers", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        raceIsOn = true;
        while (!findWinner()) {
            // slow down here if you know how
            Thread.sleep(30);
            repaint();
        } // end while

        reportRaceResults();
        reset();
    }

    /**
     * gets racer selection from user
     *
     * @return first character of user entry if user presses cancel, exits the
     *         program
     */
    private char getRacer() {
        String input = JOptionPane.showInputDialog(this, "Enter a racer:"
                + "\nt for Tortoise, h for hare," + "\nor s to start the race");
        if (input == null) {
            System.out.println("Exiting");
            System.exit(0);
        }
        if (input.length() == 0)
            return 'n';
        else
            return input.charAt(0);
    }

    /**
     * findWinners: checks for any racer whose x position is past the finish line
     *
     * @return true if any racer's x position is past the finish line or false if
     *         no racer's x position is past the finish line
     */
    private boolean findWinner() {
        for (Racer r : racerList) {
            if (r.getX() > finishX)
                return true;
        }
        return false;
    }

    /**
     * reportRaceResults : compiles winner names and prints message winners are
     * all racers whose x position is past the finish line
     */
    private void reportRaceResults() {
        raceIsOn = false;
        String results = "Racer ";
        for (int i = 0; i < racerList.size(); i++) {
            if (racerList.get(i).getX() > finishX) {
                results += (i + 1) + ", a " + racerList.get(i).getID() + ", ";
            }
        }

        JOptionPane.showMessageDialog(this, results + " win(s) the race ");

    }

    /**
     * reset: sets up for next race: sets raceIsOn flag to false clears the list
     * of racers resets racer position to FIRST_RACER enables checkboxes and
     * radio buttons
     * @throws InterruptedException
     */
    private void reset() throws InterruptedException {
        char answer;
        String input = JOptionPane.showInputDialog(this, "Another race? (y, n)");
        if (input == null || input.length() == 0) {
            System.out.println("Exiting");
            System.exit(0);
        }

        answer = input.charAt(0);
        if (answer == 'y' || answer == 'Y') {
            raceIsOn = false;
            racerList.clear();
            app.prepareToRace();
            app.runRace();
        } else
            System.exit(0);
    }

    /**
     * main instantiates the Race object app
     * calls runRace method
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        app = new Race();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.prepareToRace();
        app.runRace();
    }


}