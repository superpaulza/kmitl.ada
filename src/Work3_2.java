import java.util.*;
public class Work3_2 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int MAX = 100;
        int[] arr = new int[MAX];
        Random(arr,0,50);
        arr[0] = 9; arr[arr.length-1] = 9;
        System.out.println("Unsorted Data (Sum of Data: " + findArraySum(arr) + ")");
        System.out.println(Arrays.toString(arr));
        //
        QuickSort(arr, 0, arr.length-1);
        System.out.println("Sorted Data (Sum of Data: " + findArraySum(arr) + ")");
        System.out.println(Arrays.toString(arr));
        //
        long stop = System.currentTimeMillis();
        System.out.println("Time Usage = " + (stop-start) + " ms.");        
    }

    public static void Random(int[] arr, int min, int max) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*(max - min + 1) + min);
        }
    }

    public static int findArraySum(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }    
    
   public static void QuickSort(int[] arr, int i, int j) {
        if (i < j) {
            int p = j + 1;
            int k = Partition(arr, i, p); //Scan Ai -> & <- Ap
            QuickSort(arr, i, k-1);
            QuickSort(arr, k+1, j);
        }
    }

    public static int Partition(int[] arr, int m, int p) {
        int i = m, t = arr[m];
        //System.out.println("Start: " + t + " L: " + m + " R: " + p);
        while(i <= p) {
            do {
                p--;
            } while (((p-1) > 0) && arr[p] > t);
            do {
                i++;
            } while (((i+1) < arr.length) && arr[i] < t);
            if (i < p) Exchange(arr, i, p);
            else Exchange(arr, m, p);
            //System.out.println(Arrays.toString(arr));
            //System.out.println("L(>" + t + "): " + i + " R(>" + t + "): " + p);
        }
        return p; //k = p
    }

    public static void Exchange(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}