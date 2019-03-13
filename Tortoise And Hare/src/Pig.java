/**  Tortoise class
 *    inherits from abstract Racer class
 */

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Pig extends Racer
{
    private int speed;
    private Random rand;
    private boolean isMorphed = false;

    /** Default Constructor: calls Racer default constructor
     */
    public Pig( )
    {
        super( );
        setRandAndSpeed();
    }

    /** Constructor
     *    @param rID  racer Id, passed to Racer constructor
     *    @param rX    x position, passed to Racer constructor
     *    @param rY    y position, passed to Racer constructor
     */
    public Pig( String rID, int rX, int rY )
    {
        super( rID, rX, rY );
        setRandAndSpeed();
    }

    /** move:  calculates the new x position for the racer
     *   Tortoise move characteristics: "slow & steady wins the race"
     *      increment x by 1 most of the time
     */
    public void move( )
    {
        int move =  rand.nextInt( 100 )  + 1;
        if ( move < speed )
            setX( getX( ) + 1 );
    }

    /** draw: draws the Tortoise at current (x, y) coordinate
     *       @param g   Graphics context
     */
    public void draw( Graphics g )
    {
        int startX = getX( );
        int startY = getY( );

        if (isMorphed) {

            g.setColor(Color.MAGENTA);
        }
        else {
            g.setColor(new Color(50, 150, 50)); // dark green
        }

        //body
        g.fillOval( startX - 20, startY, 15, 25 );

        //head
        g.fillOval( startX - 57, startY + 6,  45, 30 );

        //flatten bottom
        g.clearRect( startX - 90, startY + 31, 55, 6 );

        //feet
        g.setColor( new Color( 54, 129, 33 ) );  // brown
        g.fillOval( startX - 37, startY + 12,  6, 9 );
        g.fillOval( startX - 13, startY + 12, 7, 6 );
    }

    private void setRandAndSpeed( ) {
        // percentage of time (between 90 - 99%) that this tortoise moves each turn
        rand = new Random( );
        speed = rand.nextInt( 10 ) + 90;
    }
    @Override

    public void morph(Graphics g) {

        isMorphed = true;

        draw(g);

    }
}