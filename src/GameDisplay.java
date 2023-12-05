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

    public void settings() {
        size(width, height);//Adjust the screen
    }

    public void setup() {
        mario = new Mario(25,380,10,10,1);
        for (int i = 300; i < 380; i+=20) {
            carts.add(new Cart(25, i+30, 10, 10, 1,0));
        }
        int sum = 0;
        for (int i = 0; i < carts.size(); i++) {
            sum += carts.get(i).getY();
        }
        int middleY = sum / carts.size();//Setup Mario in the middle
        mario = new Mario(25, middleY, 10, 10, 1);
    }

    public void draw() {
        background(255); //background of screen
        fill(0, 255, 0);//Fills in the track
        rect(0, 250, width, 180);
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
        if (mario.getX() > height - 50) { // assuming the end is at the bottom of the screen
            println("You win");
            noLoop(); // stop the game
        }
        for (Cart cart : carts) {
            if (mario.getBounds().intersects(cart.getBounds())) {
                println("Fail");
                noLoop(); // stop the game
            }
        }
        System.out.println();
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
            Bullet bullet = new Bullet(mario.getX(), mario.getY(), (float) xDirection, (float) yDirection);
            bullets.add(bullet);
        }
    }
    public static void main(String[] args) {
        PApplet.main("GameDisplay");
    }


}
