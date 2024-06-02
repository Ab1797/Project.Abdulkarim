package Day2.Salary;


import java.util.Scanner;

public class MyMethod {

    public static double CalcBMI(double weight, double height){

        return weight / Math.pow(height /100 ,2);
    }

    public static String getStatus (double bmi){

        if (bmi < 13.5) return "Under Weight";
        else if (bmi < 20)  return  "Normal";
        else if (bmi < 30)  return  "Pre Obese";
        else return "Obese";
    }


    public  String getStatus (double[] bmis){
        var status = new String[bmis.length];

        for (int i = 0; i < bmis.length; i++){
            var bmi = bmis[i];

            if (bmi < 18.5) status[i] = "Under Weight";
            else if (bmi < 25) status[i] = "Normal";
            else if (bmi < 30)  status[i] = "Pre Obese";
            else  status[i] =  "Obese";
        }
        return "";
    }
}