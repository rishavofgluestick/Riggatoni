import processing.core.PApplet;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
public class Bullet {
    private float x, y, marioX, marioY, bulletspeed;
    private float xSpeed, ySpeed;
    private  final int DIAMETER = 5;

    public Bullet(float marioX, float marioY, float bulletSpeed) {
        this.x=marioX;
        this.y=marioY;
        this.marioX=marioX;
        this.marioY=marioY;
        this.bulletspeed=bulletSpeed;
    }

    public void draw(PApplet window) {
        window.ellipse(x, y, DIAMETER, DIAMETER);
        window.fill(0,10,255);
    }

    public void aimat(int mouseX, int mouseY){
        xSpeed=bulletspeed* ((mouseX-marioX)/500);
        ySpeed=bulletspeed*((mouseY-marioY)/500);

    }

    public void move() {
        x += xSpeed;
        y += ySpeed;

    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, DIAMETER, DIAMETER);
    }
}
