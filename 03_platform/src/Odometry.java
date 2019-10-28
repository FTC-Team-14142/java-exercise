public class Odometry {

    protected Vector position = Vector.ZERO;
    protected Vector orientation = new Vector(1, 0, 0);

    public static void main(String[] args) {

        Odometry odo = new Odometry();

        Vector v = new Vector(0, -1, 0);
        double a = Math.atan((double) v.y / (double) v.x);
        System.out.println(a/Math.PI);

        System.out.println(v.angle()/Math.PI);
    }

    public Vector getPosition() {

        return position;
    }

    public Vector getOrientation() {

        return orientation;
    }
}
