import processing.core.PApplet;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
public class Bullet {
    private float x, y;
    private float xSpeed, ySpeed;
    private  final int DIAMETER = 5;

    public Bullet(float x, float y, float xSpeed, float ySpeed){
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void draw(PApplet window) {
        window.ellipse(x, y, DIAMETER, DIAMETER);
        window.fill(0,10,255);
    }

    public void move() {
        x += xSpeed;
        y += ySpeed;
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, DIAMETER, DIAMETER);
    }
}
