import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int ran = 11;
        double ranlong = 100000;
        int ranInt = (int)ranlong;
        System.out.println(ranInt);
        int a = -1;
        do {
            System.out.println(ranInt);
            a++;
        } while (a>=5);
        System.out.println("Hello world!");
        System.out.printf("small number %d and big number %f", ran, ranlong);
    }
}