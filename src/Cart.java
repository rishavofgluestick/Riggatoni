import processing.core.PApplet;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
public class Cart {
    private float x, y;
    private float xSpeed;
    private float w, h;
    private int position;

    public Cart(float x, float y, float width, float height, float xSpeed, int position){
        this.x = x;
        this.y = y;
        this.w = width;
        this.h = height;
        this.xSpeed = xSpeed;
        this.position = position;
    }

    public void draw(PApplet window) {
        window.rect(x, y, w, h);
        window.fill(0,10,255); //blue
    }

    public int getPosition(){
        return position;
    }

    public void move() {
        x = x + xSpeed;
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, (int)w, (int)h);
    }

    public void slowDown() {
        xSpeed *= 0.2; // slows down the cart by 50%
    }
}
