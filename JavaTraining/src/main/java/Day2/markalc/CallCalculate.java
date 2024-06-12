package Day2.markalc;



import java.util.Scanner;

public class CallCalculate {

    public static void main(String[] args) {

        var sc = new Scanner(System.in);

        System.out.println("Enter Mark & FullMark:  ");
        double m = sc.nextDouble();
        double f = sc.nextDouble();

        double persent = CalculateMarks.markCalc(m,f);
        String status = CalculateMarks.showResult(persent);

        System.out.println("you get: " + status);
    }
}