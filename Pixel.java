import java.util.*;
public class Pixel {
    int r;
    int g;
    int b;

    public Pixel() {
        r = (int) (Math.random() * 255);
        g = (int) (Math.random() * 255);
        b = (int) (Math.random() * 255);
    }

    public Pixel(int red, int green, int blue) {
        r = red;
        g = green;
        b = blue;
    }

    public String toString() {
        return r + " " + g + " " + b + "\n";
    }
}
