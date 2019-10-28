import java.lang.Math;
import java.util.Objects;

public class Vector {

    /**
     * The number of fixed decimal places.
     */
    public static final int precision = 3;
    public static final int factor = (int) Math.pow(10, Vector.precision);

    /**
     * The zero vector.
     */
    public static final Vector ZERO = new Vector(0, 0, 0);

    /**
     * The x coordinate.
     */
    public final int x;

    /**
     * The y coordinate.
     */
    public final int y;

    /**
     * The z coordinate.
     */
    public final int z;

    /**
     * The length of the vector.
     */
    public final int length;

    /**
     * The angle of the vector, between -pi and pi.
     */
    public final int angle;

    /**
     * Create a new vector.
     *
     * @param x
     * @param y
     * @param z
     */
    public Vector(int x, int y, int z) {

        this.x = x;
        this.y = y;
        this.z = z;

        this.length = this.calculateLength();
        this.angle = this.calculateAngle();
    }

    public int hashCode() {

        return Objects.hash(this.x, this.y, this.z);
    }

    public boolean equals(Object other) {

        if (other == null) return false;

        else if (! (other instanceof Vector)) return false;

        else {

            if (this.x == ((Vector) other).x && this.y == ((Vector) other).y && this.z == ((Vector) other).z) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public String toString() {

        return String.format("Vector{x: %d, y: %d, z: %d, length: %d}", this.x, this.y, this.z, this.length);
    }

    /**
     * Calculate the length of the vector.
     *
     * @return the length of the vector
     */
    protected int calculateLength() {

        return (int) (Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2)));
    }

    /**
     * Add another vector to this vector and return the result.
     *
     * @param other the vector to add
     * @return the resulting vector
     */
    public Vector add(Vector other) {

        return new Vector(
                this.x + other.x,
                this.y + other.y,
                this.z + other.z
        );
    }

    /**
     * Subtract another vector from this vector and return the result.
     *
     * @param other the vector to subtract.
     * @return the resulting vector
     */
    public Vector subtract(Vector other) {

        return new Vector(
                this.x - other.x,
                this.y - other.y,
                this.z - other.z
        );
    }

    /**
     * Multiply the vector with a scalar.
     *
     * @param factor the scalar factor
     * @return the resulting vector
     */
    public Vector multiply(int factor) {

        return new Vector(
                (int) (this.x * ((double) factor / Vector.factor)),
                (int) (this.y * ((double) factor / Vector.factor)),
                (int) (this.z * ((double) factor / Vector.factor))
        );
    }

    /**
     * Divide the vector by a scalar.
     *
     * @param divisor the scalar divisor
     * @return the resulting vector
     * @throws ArithmeticException if attempted to divide by zero
     */
    public Vector divide(int divisor) {

        if (divisor == 0) throw new ArithmeticException("divide by zero");

        return new Vector(
                (int) (this.x / ((double) divisor / Vector.factor)),
                (int) (this.y / ((double) divisor / Vector.factor)),
                (int) (this.z / ((double) divisor / Vector.factor))
        );
    }

    /**
     * Flatten the vector, so that its z component is 0, and return the result.
     *
     * @return the resulting, flat vector
     */
    public Vector flatten() {

        return new Vector(this.x, this.y, 0);
    }

    /**
     * Normalize the vector, so that its length is 1, and return the result.
     *
     * @return the normalized vector
     */
    public Vector normalize() {

        return this.divide(this.length);
    }

    protected int calculateAngle() {

        return 0;
    }
}
