package Day2.Salary;



import java.util.Scanner;

public class CallMethod {

    public static void main(String[] args) {

        var sc = new Scanner(System.in);

        System.out.println("Enter weight and height");
        double w = sc.nextDouble();
        double h = sc.nextDouble();

        double bmi = MyMethod.CalcBMI(w,h);
        String status = MyMethod.getStatus(bmi);

        System.out.println("Your bmi: " + bmi + ", " + status);


    }

}