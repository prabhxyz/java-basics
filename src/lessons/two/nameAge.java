package lessons.two;

import java.util.Scanner;

public class nameAge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("What's your name? ");
        String name = input.next();
        System.out.print("How old are you? ");
        int age = input.nextInt();
        System.out.printf("Hi %s\n", name);
        System.out.printf("You are %d years old", age);
    }
}
