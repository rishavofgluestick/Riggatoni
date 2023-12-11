import processing.core.PApplet;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

public class GameDisplay extends PApplet {

    private Mario mario;
    private ArrayList<Cart> carts = new ArrayList<>();
    private ArrayList<Bullet> bullets = new ArrayList<>();
    private int width=800;
    private int height =800;
    private int round=1;

    public void settings() {
        size(width, height);//Adjust the screen
    }

    public void setup() {
        if(round==1){
            mario = new Mario(25,370,60,60,1);
            for (int i = 150; i <= 300; i+=100) {
                carts.add(new Cart(25, i+20, 60, 60, 1,0));
            }
            for (int i = 450; i <= 550; i+=100) {
                carts.add(new Cart(25, i+20, 60, 60, 1,0));
            }
            int sum = 0;
            for (int i = 0; i < carts.size(); i++) {
                sum += carts.get(i).getY();
            }
        }
        if(round==2){
            mario = new Mario(25,370,60,60,1);
            for (int i = 150; i <= 300; i+=100) {
                carts.add(new Cart(100, i+20, 60, 60, 1,0));
            }
            for (int i = 450; i <= 550; i+=100) {
                carts.add(new Cart(100, i+20, 60, 60, 1,0));
            }
            int sum = 0;
            for (int i = 0; i < carts.size(); i++) {
                sum += carts.get(i).getY();
            }
        }

    }

    public void draw() {
        background(255); //background of screen
        fill(0, 255, 0);//Fills in the track
        rect(0, 150, width, 500);
        fill(255, 0, 0);//fills in Mario
        mario.draw(this);
        mario.move();
        fill(0, 0, 255);//fills in the carts
        for (Cart cart : carts) {
            cart.draw(this);
        }
        for (Cart cart : carts) {
            cart.move();
        }
        for (Bullet bullet : bullets) {
            bullet.draw(this);
        }
        for (Bullet bullet : bullets) {
            bullet.move();
        }
        detectCollision();
        checkEnd();

    }

    public void detectCollision() {
        for (Iterator<Bullet> bulletIterator = bullets.iterator(); bulletIterator.hasNext();) {
            Bullet b = bulletIterator.next();
            for (Cart c : carts) {
                if (b.getBounds().intersects(c.getBounds())) {
                    c.slowDown(); // slows down the cart
                    bulletIterator.remove(); // removes the bullet
                }
            }
        }

    }
    public void checkEnd() {
        textSize(43);
        if (mario.getX() > width - 60 && round==2) { // assuming the end is at the bottom of the screen
            background(0);
            fill(0,255,0);
            textSize(100);
            text("You WIN!", 180,380);

            noLoop(); // stop the game
        }
        if (mario.getX() > width - 60 && round==1) { // assuming the end is at the bottom of the screen
            for (int i = carts.size()-1; i >=0; i--) {
                carts.remove(i);
            }
            mario = new Mario(25,370,60,60,1);
            for (int i = 150; i <= 300; i+=100) {
                carts.add(new Cart(100, i+20, 60, 60, 2,0));
            }
            for (int i = 450; i <= 550; i+=100) {
                carts.add(new Cart(100, i+20, 60, 60, 2,0));
            }
            int sum = 0;
            for (int i = 0; i < carts.size(); i++) {
                sum += carts.get(i).getY();
            }
            round++;

        }
        for (Cart cart : carts) {
            if (cart.getX()>width-60) {
                background(0);
                fill(255,0,0);
                textSize(100);
                text("You Lose!", 170, 380);
                noLoop(); // stop the game
            }
        }

    }
    public void text(){
        checkEnd();
    }
    public void fullScreen(){
        fullScreen();
    }

    public void mousePressed() {
        if (mouseButton == LEFT) {
            double xDirection = mouseX - mario.getX();
            double yDirection = mouseY - mario.getY();
            double magnitude = Math.sqrt(xDirection * xDirection + yDirection * yDirection);
            xDirection /= magnitude;
            yDirection /= magnitude;
            Bullet bullet = new Bullet(mario.getX()+60, mario.getY()+60, 100);
            bullet.aimat(mouseX,mouseY);
            bullets.add(bullet);
        }
    }
    public static void main(String[] args) {
        PApplet.main("GameDisplay");
    }


}
