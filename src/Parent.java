import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import processing.core.PApplet;

import javax.xml.stream.Location;

public class Parent extends PApplet {
    protected Location location;
    protected int Velocity = (int) Math.random() * 20 + 1;
    protected boolean isAlive;
    protected Location x;
    protected Location y;


    public void Moving(boolean isAlive, Location location, int Velocity) {
        if (isAlive == true) {
            Velocity++;
        }
    }
}
