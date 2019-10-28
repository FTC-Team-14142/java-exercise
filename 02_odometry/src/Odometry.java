public class Odometry {

    /**
     * Position vector.
     */
    protected Vector position = Vector.ZERO;

    /**
     * Orientation vector.
     * Should always have length 1.
     */
    protected Vector orientation = new Vector(1, 0, 0).normalize();

    public static void main(String[] args) {

    }

    /**
     * Drive in the direction of the orientation.
     *
     * @param distance
     */
    public void drive(int distance) {


    }

    /**
     * Adjust the orientation of the robot.
     * A value of 360_000 amounts to one full rotation.
     * Positive numbers mean a counter-clockwise rotation,
     * while negative numbers mean a clockwise rotation.
     *
     * @param degreesDelta the number of degrees to turn
     */
    public void turn(int degreesDelta) {

    }

    public Vector getPosition() {

        return position;
    }

    public Vector getOrientation() {

        return orientation;
    }
}
