package Day1;



import java.util.Calendar;
import java.util.Scanner;

public class PhoneCheck {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Phone Number: ");
        String phone = sc.nextLine();

        if(phone.length() != 10  && !phone.startsWith("05"))
        {
            System.out.println("Not valid number");
        }
        else
        {
            for (int i =0; i == phone.length(); i++){

                if (i == 10){
                    char checkPhone = phone.charAt(i);
                    Character.isDigit(checkPhone);
                }
            }
            System.out.println("Valid Phone Number *_*");
        }
    }
}