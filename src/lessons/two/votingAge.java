package lessons.two;

import java.util.Scanner;

public class votingAge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How old are you? ");
        int age = input.nextInt();
        if (age <= 17){
            System.out.println("You are not old enough to vote.");
        } else {
            System.out.println("You are old enough to vote.");
        }
    }
}
