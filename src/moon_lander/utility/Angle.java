package moon_lander.utility;

/**
 * Created by Liam Dodds on 14/01/2015.
 */
public class Angle {

    private final static double DEFAULT_INCREMENT = 5.0;

    /**
     * The angle in degrees
     */
    private double angle;

    public Angle() {
        this.angle = 0.0;
    }

    public Angle(double angle) {
        this.angle = angle;
    }

    /**
     * Gets the angle
     * @return the angle
     */
    public double getAngle() {
        return angle;
    }

    /**
     * Sets the angle
     * @param angle
     */
    public void setAngle(double angle) {
        this.angle = angle;
    }

    /**
     * Converts the angle as radians
     * @return the angle as radians
     */
    public double asRadians() {
        return Math.toRadians(angle);
    }

    public double cos() {
        return Math.cos(asRadians());
    }

    public double tan() {
        return Math.tan(asRadians());
    }

    public double sin() {
        return Math.sin(asRadians());
    }

    /**
     * Turn the angle to left
     */
    public void turnLeft() {
        turnLeft(DEFAULT_INCREMENT);
    }

    /**
     * Turn the angle to the right
     */
    public void turnRight() {
        turnRight(DEFAULT_INCREMENT);
    }

    /**
     * Turn the angle to the left
     * @param increment the amount to turn the angle
     */
    public void turnLeft(double increment) {
        angle -= increment;

        if(angle < 0) {
            angle = 360 + angle;
        }
    }

    /**
     * Turn the angle to the right
     * @param increment the amount to turn the angle
     */
    public void turnRight(double increment) {
        angle += increment;

        if(angle > 360) {
            angle = angle - 360;
        }
    }
}
