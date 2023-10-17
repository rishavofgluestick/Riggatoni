import processing.core.PApplet;

import java.awt.*;
import javax.xml.stream.Location;
import java.util.ArrayList;
public class Mario {
    private float x, y;
    private float xSpeed, ySpeed;
    private float w, h;
    private int r,g,b;


    public Mario(float x, float y, float w, float h, float xSpeed, float ySpeed){
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.r=r;
        this.b=b;
        this.g=g;
    }
    public void move(){
        x+=xSpeed;
    }


    public void draw(PApplet window) {
        window.rect(x, y, w, h);
        window.fill(0,0,9);//red

    }
}
