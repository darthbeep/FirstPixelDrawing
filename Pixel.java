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

    public static void main(String[] args) {
        Pixel p = new Pixel();
        System.out.println(p);
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            String s = scan.nextLine();
        }
    }

}
