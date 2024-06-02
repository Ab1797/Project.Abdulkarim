package Day2.Salary;

import java.util.Arrays;

public class ArraysAgain {

    public static void main(String[] args) {
        int[] xArr = {10,20,30};
        int[] yArr = xArr;
//       make a new array copy of x array using "copyOf"
        int[] zArr = Arrays.copyOf(xArr, xArr.length);

        System.out.println(Arrays.toString(xArr));
        System.out.println(Arrays.toString(yArr));
        System.out.println(Arrays.toString(zArr));

        yArr[1] += 3;
        xArr[1] += 1;

        System.out.println(Arrays.toString(xArr));
        System.out.println(Arrays.toString(yArr));
        System.out.println(Arrays.toString(zArr));
    }
}