package lessons.two;

import java.util.Scanner;
import java.util.Random;

public class simpleGuessing {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        int secret = rand.nextInt(0, 21);
        boolean correct = false;
        while (!correct) {
            System.out.print("Guess a number between 1 and 20: ");
            int num = input.nextInt();
            if (num>secret) {
                System.out.println("Too High.");
            } else if (num<secret) {
                System.out.println("Too Low.");
            } else {
                System.out.println("Correct!");
                correct = true;
            }
        }
    }
}
