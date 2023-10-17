import java.awt.*;
import java.util.ArrayList;
import processing.core.PApplet;
import java.awt.*;
public class GameDisplay extends PApplet {

    private Mario mario;
    private ArrayList<Cart>carts = new ArrayList<>();
    private Color color;
    private Cart cart;

    private int width=800;
    private int height =800;


    public void settings() {
        size(width, height);
    }

    public void setup() {
        mario = new Mario(25,380,10,10,1,0);
        for (int i = 300; i < 380; i+=20) {
            carts.add(new Cart(25, i, 10, 10, 1));
        }

    }


    public void draw() {
        background(255);//background of screen
        fill(0,255,0);


        rect(0, 250, width, 180);
        fill(255,0,0);
        mario.draw(this);
        mario.move();
        fill(0,0,255);
        for(Cart cart:carts) {
            cart.draw(this);
        }
        for(Cart cart:carts) {
            cart.move();
        }







    }

    public static void main(String[] args) {
        PApplet.main("GameDisplay");
    }
}
