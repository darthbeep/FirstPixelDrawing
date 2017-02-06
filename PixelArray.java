
import java.io.*;
import java.util.*;

public class PixelArray {

    Pixel arr[][];
    int x;
    int y;

    public PixelArray() {
        this(500, 500);
    }

    public PixelArray(int xCor, int yCor) {
        arr=new Pixel[xCor][yCor];
        x = xCor;
        y = yCor;
    }

    public  void writeToFile() {
        String write = "";
        write += "P3\n" + x + " " + y + " 255\n";
        for (Integer i = 0; i < x; i++) {
            String temp1 = "";
            String temp2 = "";
            String temp3 = "";
            String temp4 = "";
            String temp5 = "";
            for (Integer j = 0; j < y; j++) {
                if(i < x / 5) {
                    temp1 += arr[i][j];
                }
                else if (i < x * 2 / 5){
                    temp2 += arr[i][j];
                }
                else if (i < x * 3 / 5){
                    temp3 += arr[i][j];
                }
                else if (i < x * 4 / 5){
                    temp4 += arr[i][j];
                }
                else {
                    temp5 += arr[i][j];
                }
                //temp += "0 0 0\n";
                //write = write + "0 0 0\n";
            }
            //System.out.println(i);
            write += temp1 + temp2 + temp3 + temp4 + temp5;
        }
        try {
            PrintWriter p = new PrintWriter(new File("pic.ppm"));
        p.print(write);
        p.close();
        } catch(Exception e) {
            System.out.println("There was a problem with saving to the pic.ppm file.");
        }

    }

    //The gradiant triangles in the background
    public void pattern1() {
        for (Integer i = 0; i < x; i++) {
            for (Integer j = 0; j  < y; j ++) {
                arr[i][j] = new Pixel(i % 255, j % 255, (i + j) % 255);
            }
        }
    }

    //The static trapezoid
    public void pattern2() {
        for (Integer i = 50; i < 150; i++) {
            for (Integer j = 50; j < 150; j++) {
                if(i+j < y) {
                    arr[i][i+j]=new Pixel(); //Note that this creates pixels of a random color
                }
            }
        }
    }

    //The circle
    public void pattern3() {
        for (Integer i = 0; i < 500; i++) {
            for (Integer j = 0; j < 500; j++) {
                if((Math.pow(i - 400, 2)) + (Math.pow(j - 400, 2)) > 200 && (Math.pow(i - 400, 2)) + (Math.pow(j - 400, 2)) < 250) {
                    arr[i][j] = new Pixel((i+j) % 255, (i+j) % 255, (i+j) % 255);
                }
            }
        }
    }

    public static void main(String[] args) {
        PixelArray p = new PixelArray();
        p.pattern1();
        p.pattern2();
        p.pattern3();
        p.writeToFile();
    }
}
