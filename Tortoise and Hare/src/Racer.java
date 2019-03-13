import java.awt.Graphics;

/**
 * @author Patty
 *
 */
public abstract class Racer {
    private String ID;	// racer ID
    private int x;			// x position
    private int y;			// y position

    /** default constructor
     *  Sets ID to blank
     */
    public Racer() {
        ID = "";
    }

    /** Constructor
     * @param rID	racerID
     * @param rX	x position
     * @param rY	y position
     */
    public Racer(String rID, int rX, int rY) {
        ID = rID;
        x = rX;
        y = rY;
    }
    /** accessor for ID
     * @return	ID
     */
    public String getID() {
        return ID;
    }

    /** accessor for x
     * @return	current x value
     */
    public int getX() {
        return x;
    }

    /** accessor for y
     * @return	current y value
     */
    public int getY() {
        return y;
    }

    /** mutator for x
     * @param	newX	new value for x
     */
    public void setX(int newX) {
        x = newX;
    }

    /** mutator for y
     * @param 	newY	new value for y
     */
    public void setY(int newY) {
        y = newY;
    }

    /** abstract method for Racer's move
     */
    public abstract void move();

    /** abstract method for drawing Racer
     *  @param	g	Graphics context
     */
    public abstract void draw( Graphics g );

}
