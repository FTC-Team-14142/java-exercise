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

    /**
     * Drive in the direction of the orientation.
     *
     * @param distance
     */
    public void drive(int distance) {

        // create delta vector and add it to current position
        this.position = this.position.add(this.orientation.multiply(distance));
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

        // convert degrees to radians
        double radiansDelta = degreesDelta / 180 * Math.PI;
        // add angles
        double radiansNew = (this.orientation.angle + radiansDelta) / Vector.factor;

        // calculate new x and y coordinates
        int newX = (int) (Vector.factor * Math.cos(radiansNew));
        int newY = (int) (Vector.factor * Math.sin(radiansNew));

        // create new normalized orientation vector from coordinates
        this.orientation = new Vector(newX, newY, 0).normalize();
    }

    /**
     * Turn the robot so that it faces the given position.
     *
     * @param pos the position to turn to
     */
    public void turnToPosition(Vector pos) {

        Vector delta = pos.subtract(this.position);
        int radiansDelta = delta.angle - this.orientation.angle;
        int degreesDelta = (int) (radiansDelta * 180 / Math.PI);
        this.turn(degreesDelta);
    }

    /**
     * Drive to the given position in a direct line.
     *
     * @param pos the position to drive to
     */
    public void driveToPosition(Vector pos) {

        this.turnToPosition(pos);
        int distance = pos.subtract(this.position).length;
        this.drive(distance);
    }

    public Vector getPosition() {

        return position;
    }

    public Vector getOrientation() {

        return orientation;
    }
}
