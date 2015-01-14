package moon_lander.attributes;

import java.util.Vector;

/**
 * Created by Liam Dodds on 14/01/2015.
 */
public class Vector2D {

    private int x;
    private int y;

    public Vector2D() {
        x = 0;
        y = 0;
    }

    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public void scale(double scalar) {
        this.x *= scalar;
        this.y *= scalar;
    }

    public void add(Vector2D vector) {
        this.x += vector.getX();
        this.y += vector.getY();
    }

    public void addX(int increment) {
        this.x += increment;
    }

    public void addY(int increment) {
        this.y += increment;
    }

    public void add(int incX, int incY) {
        this.x += incX;
        this.y += incY;
    }

    public void add(int increment) {
        this.x += increment;
        this.y += increment;
    }
}
