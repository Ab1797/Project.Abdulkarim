package Day1;
import java.util.Scanner;

public class CheckDay
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter day number:");

        int day = sc.nextInt();

        if (day == 7 || day >= 1 && day <= 4){
            System.out.println("it's a workDay");
        } else if (day == 5 || day == 6) {
            System.out.println("it's a  offDay");
        }
        else {
            System.out.println("invalid input");
        }

        switch (day){

            case 1:
                System.out.println("the day number = sunday");
                break;
            case 2:
                System.out.println("the day number = monday");
                break;
            case 3:
                System.out.println("the day number = tuesday");
                break;
            case 4:
                System.out.println("the day number = wednesday");
                break;
            case 5:
                System.out.println("the day number = thursday");
                break;
            case 6:
                System.out.println("the day number = friday");
                break;
            case 7:
                System.out.println("the day number = saturday");
                break;
        }
    }
}