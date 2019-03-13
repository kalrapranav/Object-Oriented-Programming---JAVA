import javax.swing.*;
import java.awt.*;
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

        while (input != 's' && input != 'S')
        {
            /* 1. ***** Student write this switch statement
             * input local char variable contains the racer type
             * entered by the user.
             * If input is 'T' or 't',
             * 	add a Tortoise object to the ArrayList named racerList
             * 	which is an instance variable of this class.
             * The API of the Tortoise constructor is:
             * 	Tortoise( String ID, int startX, int startY )
             * a sample call to the constructor is
             * 	new Tortoise( "Tortoise". START_LINE, yPos )
             * 	where START_LINE is a constant local variable
             * 		representing the starting x position for the race
             * 	and yPos is a local variable representing the next
             * 		racer's y position
             *
             * If input is 'H' or 'h',
             * 	add a Hare object to the ArrayList name racerList.
             * The API of the Tortoise constructor is:
             * 	Hare( String ID, int startX, int startY )
             * a sample call to the constructor is
             * 	new Hare( "Hare". START_LINE, yPos )
             * 	where START_LINE is a constant local variable
             * 		representing the starting x position for the race
             * 	and yPos is a local variable representing the next
             * 		racer's y position
             *
             * After adding a racer to the ArrayList racerList,
             * 	increment yPos by the value of the
             * 	constant local variable RACER_SPACE
             *
             * If input is anything other than 'T','t','H', or 'h',
             * 	pop up an error dialog box
             * A sample method call for the output dialog box is :
             * 	JOptionPane.showMessageDialog( this, "Message" );
             *
             */
            // write your switch statement here
        switch (input)
        {
            case 't':
                racerList.add(new Tortoise("Tortoise", START_LINE, yPos));
                yPos+=RACER_SPACE;
                break;
            case 'T':
                racerList.add(new Tortoise("Tortoise", START_LINE, yPos));
                yPos+=RACER_SPACE;
                break;
            case 'h':
                racerList.add(new Hare("Hare", START_LINE, yPos));
                yPos+=RACER_SPACE;
                break;
            case 'H':
                racerList.add(new Hare("Hare", START_LINE, yPos));
                yPos+=RACER_SPACE;
                break;
            case 'b':
                racerList.add(new Bull("Bull", START_LINE, yPos));
                yPos+=RACER_SPACE;
                break;
            case 'B':
                racerList.add(new Bull("Bull", START_LINE, yPos));
                yPos+=RACER_SPACE;
                break;
            case 'q':
                racerList.add(new RedBall("RedBall", START_LINE, yPos));
                yPos+=RACER_SPACE;
                break;
            case 'Q':
                racerList.add(new RedBall("RedBall", START_LINE, yPos));
                yPos+=RACER_SPACE;
                break;
            default:
                JOptionPane.showMessageDialog(this, "Message");
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
                for (int i = 0; i < racerList.size(); i++)
                {
                    racerList.get(i).move();
                    racerList.get(i).draw(g);
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
                for (int i = 0; i < racerList.size(); i++)
                {
                    racerList.get(i).draw(g);
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
                + "\nt for Tortoise, h for hare,b for bull, q for ball" + "\nor s to start the race");
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