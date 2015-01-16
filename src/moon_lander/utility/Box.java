package moon_lander.utility;

/**
 * Created by Liam Dodds on 14/01/2015.
 */
public class Box {

    private int x;
    private int y;
    private int width;
    private int height;

    public Box(Vector2D position, int width, int height) {
        this.x = position.getX();
        this.y = position.getY();
        this.width = width;
        this.height = height;
    }

    public int top() { return y; }
    public int bottom() { return y + height; }
    public int left() { return x; }
    public int right() { return x + width; }

    public int centerX() {
        return x + (width / 2);
    }

    public int centerY() {
        return y + (width / 2);
    }
}
