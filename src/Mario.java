import processing.core.PApplet;
import processing.core.PImage;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
public class Mario {
    private float x, y;
    private double xSpeed;
    private float w, h;

    public Mario(float x, float y, float w, float h, double xSpeed){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.xSpeed = xSpeed;
    }

    public void move(){
        x += xSpeed;
    }

    public void draw(PApplet window, PImage img) {
       // window.rect(x, y, w, h);
        window.fill(0,0,9); //red
        window.image(img, x, y, w, h);
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
