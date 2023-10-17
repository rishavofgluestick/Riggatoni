import processing.core.PApplet;

import java.awt.*;

public class Cart {
    private float x, y;
    private float xSpeed, ySpeed;
    private float w, h;
    private Color color;
    int r,g,b;

        public Cart(float x, float y, float width, float height, float xSpeed){
            this.x= x;
            this.y=y;
            this.w=width;
            this.h=height;
            this.xSpeed=xSpeed;
            this.r=r;
            this.b=b;
            this.g=g;

        }

    public void draw(PApplet window) {
        window.rect(x, y, w, h);
        window.fill(0,10,255);//blue
    }


    public void move() {
        x= x+xSpeed;

    }

    public float getX(){
            return x;
    }

    public float getY(){
        return y;
    }
}
