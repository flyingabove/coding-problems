package hacckerank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.IntStream;

public class RunningMedian {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        DecimalFormat decimalFormat = new DecimalFormat("###,###,###,###.0");
        int i = 1;
        while(i < a.length+1){
            int[] testArray = Arrays.copyOfRange(a, 0, i);
            double median = getMedian(testArray);
            System.out.println(decimalFormat.format(median));
            i++;
        }
    }

    public static double getMedian(int[] array){

        if(array.length%2 == 1) {
            int midIndex = array.length/2;
            return array[midIndex];
        }
        else{
            int midIndex = array.length/2;
            double median = (array[midIndex] + array[midIndex-1])/2.0;
            return  median;
        }
    }
}