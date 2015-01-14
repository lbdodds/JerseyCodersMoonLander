package moon_lander;

import moon_lander.attributes.Angle;
import moon_lander.attributes.Box;
import moon_lander.attributes.Vector2D;

import java.awt.*;
import java.util.Random;

/**
 * Created by Liam Dodds on 14/01/2015.
 */
public class Entity {

    protected Random random;
    protected Angle angle;
    protected Vector2D position;
    protected Vector2D velocity;

    protected int width;
    protected int height;

    public Entity() {
        random = new Random();
        angle = new Angle();
        position = new Vector2D();
        velocity = new Vector2D();

        width = 0;
        height = 0;
    }

    public void reset() {
        angle = new Angle();
        position = new Vector2D();
        velocity = new Vector2D();
    }

    public int getX() {
        return this.position.getX();
    }

    public int getY() {
        return this.position.getY();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Box box() {
        return new Box(position, width, height);
    }

    public void Update() {
        position.add(velocity);
    }

    public void Draw(Graphics2D g2d) {

    }

    public Vector2D getVelocity() {
        return velocity;
    }
}
