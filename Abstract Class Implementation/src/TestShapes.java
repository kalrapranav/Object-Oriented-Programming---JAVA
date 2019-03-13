
public class TestShapes {
    public static void main(String[] args) {
        Circle circle1 = new Circle(new Point(1.0, 1.0), 1.0);
        Circle circle2 = new Circle(new Point(1.0, 1.0), 2.0);

        Shape rectangle = new Rectangle(new Point(0.0, 1.0), 1.0, 1.0);

        // Print areas
        System.out.println("Area of circle 1 is: " + circle1.computeArea());
        System.out.println("Area of circle 2 is: " + circle2.computeArea());
        System.out.println("Area of rectangle is: " + rectangle.computeArea());
        System.out.println();

        // Print positions
        System.out.println("Circle 1 is at: (" + circle1.getPosition().getX() +
                ", " + circle1.getPosition().getY() + ")");

        System.out.println("Rectangle is at: (" + rectangle.getPosition().getX() +
                ", " + rectangle.getPosition().getY() + ")");
        System.out.println();

        // Move shapes
        circle1.setPosition(new Point(3.0, 1.0));
        rectangle.movePositionRelative(new Point(1.0, 1.0));

        // Print positions
        System.out.println("Circle 1 is at: (" + circle1.getPosition().getX() +
                ", " + circle1.getPosition().getY() + ")");

        System.out.println("Rectangle is at: (" + rectangle.getPosition().getX() +
                ", " + rectangle.getPosition().getY() + ")");
        System.out.println();

        //print perimetre
        System.out.println("Perimetre of circle 1 is: " + circle1.computePerimeter());
        System.out.println("Perimetre of circle 2 is: " + circle2.computePerimeter());
        System.out.println("Perimetre of rectangle is: " + rectangle.computePerimeter());
        System.out.println();
    }
}
