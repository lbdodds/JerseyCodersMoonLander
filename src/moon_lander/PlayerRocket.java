package moon_lander;

import moon_lander.attributes.Angle;
import moon_lander.attributes.Vector2D;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * The space rocket with which player will have to land.
 * 
 * @author www.gametutorial.net
 */

public class PlayerRocket extends Entity {

    /**
     * Is rocket landed?
     */
    public boolean landed;
    
    /**
     * Has rocket crashed?
     */
    public boolean crashed;
        
    /**
     * Accelerating speed of the rocket.
     */
    private double speedAccelerating;
    /**
     * Stopping/Falling speed of the rocket. Falling speed because, the gravity pulls the rocket down to the moon.
     */
    private double speedStopping;
    
    /**
     * Maximum speed that rocket can have without having a crash when landing.
     */
    public int topLandingSpeed;

    /**
     * Image of the rocket in air.
     */
    private BufferedImage rocketImg;
    /**
     * Image of the rocket when landed.
     */
    private BufferedImage rocketLandedImg;
    /**
     * Image of the rocket when crashed.
     */
    private BufferedImage rocketCrashedImg;
    /**
     * Image of the rocket fire.
     */
    private BufferedImage rocketFireImg;

    public PlayerRocket()
    {
        super();
        Initialize();
        LoadContent();
        
        // Now that we have rocketImgWidth we set starting x coordinate.
        position.setX(random.nextInt(Framework.frameWidth - width));
    }
    
    
    private void Initialize()
    {
        random = new Random();
        
        ResetPlayer();
        
        speedAccelerating = 1;
        speedStopping = 0.5;
        topLandingSpeed = 5;
        weight = 1.5;
    }
    
    private void LoadContent()
    {
        try
        {
            URL rocketImgUrl = this.getClass().getResource("/images/rocket.png");
            rocketImg = ImageIO.read(rocketImgUrl);
            width = rocketImg.getWidth();
            height = rocketImg.getHeight();
            
            URL rocketLandedImgUrl = this.getClass().getResource("/images/rocket_landed.png");
            rocketLandedImg = ImageIO.read(rocketLandedImgUrl);
            
            URL rocketCrashedImgUrl = this.getClass().getResource("/images/rocket_crashed.png");
            rocketCrashedImg = ImageIO.read(rocketCrashedImgUrl);
            
            URL rocketFireImgUrl = this.getClass().getResource("/images/rocket_fire.png");
            rocketFireImg = ImageIO.read(rocketFireImgUrl);
        }
        catch (IOException ex) {
            Logger.getLogger(PlayerRocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Here we set up the rocket when we starting a new game.
     */
    public void ResetPlayer()
    {
        reset();
        landed = false;
        crashed = false;

        position = new Vector2D(
                Framework.frameWidth / 2 - width / 2,
                Framework.frameHeight / 2 - height / 2
        );
    }
    
    
    /**
     * Here we move the rocket.
     */
    public void Update()
    {
        speed *= friction;
        // Calculating speed for moving up or down.
        if(Canvas.keyboardKeyState(KeyEvent.VK_W)) {
            speed += speedAccelerating / weight;
        }

        if(Canvas.keyboardKeyState(KeyEvent.VK_S)) {
            speed -= speedStopping;
            if(speed < 0) speed = 0;
        }

        // Calculating speed for moving or stopping to the left.
        if(Canvas.keyboardKeyState(KeyEvent.VK_A)) {
            angle.turnLeft();
        }

        // Calculating speed for moving or stopping to the right.
        if(Canvas.keyboardKeyState(KeyEvent.VK_D)) {
            angle.turnRight();
        }

        super.Update();
    }
    
    public void Draw(Graphics2D g2d)
    {
        g2d.setColor(Color.white);
        g2d.drawString("Rocket coordinates: " + getX() + ", " + getY(), 5, 15);
        g2d.drawString("Rocket Angle: " + angle.getAngle(), 5, 35);
        g2d.drawString("Rocket Velocity: " + velocity.getX() + ", " + velocity.getY(), 5, 55);
        g2d.drawString("Rocket Speed: " + speed, 5, 75);

        // If the rocket is landed.
        if(landed)
        {
            g2d.drawImage(rocketLandedImg, getX(), getY(), null);
        }
        // If the rocket is crashed.
        else if(crashed)
        {
            g2d.drawImage(rocketCrashedImg, getX(), this.box().bottom() - rocketCrashedImg.getHeight(), null);
        }
        // If the rocket is still in the space.
        else
        {

            g2d.rotate(angle.asRadians(), box().centerX(), box().centerY());
            // If player hold down a W key we draw rocket fire.
            if(Canvas.keyboardKeyState(KeyEvent.VK_W))
                g2d.drawImage(
                        rocketFireImg,
                        getX() + 12,
                        getY() + 66,
                        null
                );
            g2d.drawImage(rocketImg, getX(), getY(), null);
            g2d.rotate(0);
        }
    }
    
}
