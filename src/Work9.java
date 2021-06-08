import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

public class Work9 {
    public static void main(String[] args) {
        //Bin Packing Problem
        //Solving by Heuristic Algorithm
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter (Bin capacity) L: "); double L = sc.nextDouble();
        System.out.print("Enter (Number of Objects) n: "); int n = sc.nextInt();
        double[] l = new double[n];
        for (int i = 0; i < l.length; i++) {
            System.out.print("n" + "[" + (i+1) + "] : "); l[i] = sc.nextDouble();
        }
        /*System.out.println("Solving by FF (First-Fit)");
        print((FF(l,L)),l);*/
        System.out.println("Solving by FFD (First-Fit Decreasing)");
        print((FF(sort(l),L)),l);

    }

    public static void print(int[] arr, double[] ans) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Item " + (i+1) + ": (" + ans[i] +")" + " stored in bin number " + (arr[i]+1));
        }
    }

    public static int[] FF(double[] l, double L) {
        int[] bin = new int[l.length];
        double[] remain = new double[l.length];
        for (int i = 0; i < l.length; i++) {
            for (int j = 0; j < l.length; j++) {
                if(remain[j] + l[i] <= L) {
                    bin[i] = j;
                    remain[j] += l[i];
                    break;
                }
            }
        }
        return bin;
    }

    public static double[] sort(double[] arr) {
        double temp = 0;
        for (int i = 0; i < arr.length; i++) {     
            for (int j = i+1; j < arr.length; j++) {     
               if(arr[i] < arr[j]) {    
                   temp = arr[i];    
                   arr[i] = arr[j];    
                   arr[j] = temp;    
               }     
            }     
        }
        return arr;
    }
}
