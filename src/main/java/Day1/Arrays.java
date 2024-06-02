package Day1;


import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter students number: ");

        int n = sc.nextInt();
        double best = 0;

        double[] marks = new double[n];

        for(int i = 0; i <n ; i++){

            System.out.println("Enter students Marks: ");
            marks[i] = sc.nextInt();

            if (marks[i] > best){
                best = marks[i];
            }
        }

        for (int i =0; i< marks.length; i++){

            if (marks[i] >= best -10){
                System.out.println(marks[i] + " => A");
            } else if (marks[i] >= best -20) {
                System.out.println(marks[i] + " => B");
            }else if (marks[i] >= best -30) {
                System.out.println(marks[i] + " => C");
            }else if (marks[i] >= best -40) {
                System.out.println(marks[i] + " => D");
            }else {
                System.out.println(marks[i] + " => F");
            }
        }
    }
}
