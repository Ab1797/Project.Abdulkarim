package Day1;

import java.util.Scanner;

    public class EvenOdd {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number");

            int x = sc.nextInt();

            String result= (x % 2 == 0) ? "Even" : "Odd";

            System.out.println(result);
        }
    }

