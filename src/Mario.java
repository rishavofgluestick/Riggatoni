import processing.core.PApplet;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
public class Mario {
    private float x, y;
    private float xSpeed;
    private float w, h;

    public Mario(float x, float y, float w, float h, float xSpeed){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.xSpeed = xSpeed;
    }

    public void move(){
        x += xSpeed;
    }

    public void draw(PApplet window) {
        window.rect(x, y, w, h);
        window.fill(0,0,9); //red
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 5,5);
    }
}
