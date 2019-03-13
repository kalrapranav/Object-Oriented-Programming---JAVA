
public abstract class Shape {

    protected Point position;

    abstract double computeArea();

    abstract double computePerimeter();

    public Point getPosition() {
        return this.position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void movePositionRelative(Point position) {
        double x = this.position.getX() + position.getX();
        double y = this.position.getY() + position.getY();

        this.position.setX(x);
        this.position.setY(y);
    }
}
