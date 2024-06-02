package Day1;

import java.util.Scanner;

public class PasswordCheck {

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter pass: ");
        String password = sc.nextLine();

        if(password.length() < 8)
        {
            System.out.println("Week Password");

        }
        else
        {
            int digitCounter = 0;
            int upperCounter = 0;

            for(int i =0; i <password.length(); i++)
            {

                char c = password.charAt(i);
                if(Character.isUpperCase(c))
                {
                    upperCounter++;
                }
                else if (Character.isDigit(c))
                {

                    digitCounter++;

                }
            }

            if (upperCounter <2 || digitCounter <2)
            {
                System.out.println("week Password");
            }
            else
            {
                System.out.println("strong Password");
            }
        }

    }
}