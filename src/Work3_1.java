import java.util.*;
public class Work3_1 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int MAX = 100;
        int[] arr = new int[MAX];
        Random(arr,0,50);
        arr[0] = 9; arr[arr.length-1] = 9;
        //
        System.out.println("Unsorted Data (Sum of Data: " + findArraySum(arr) + ")");
        System.out.println(Arrays.toString(arr));
        MergeSort(arr);
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

    //l stand for low, m for middle and h for high
    public static void MergeSort(int[] arr) {
        if (0 < arr.length-1) {
            int m = (int) Math.ceil((1+arr.length)/2);
            int arrL[] = Arrays.copyOfRange(arr, 0, m);
            int arrR[] = Arrays.copyOfRange(arr, m, arr.length);
            MergeSort(arrL);
            MergeSort(arrR);
            Merge(arr, arrL, arrR);
        }
    }

    public static void Merge(int[] arr, int[] arrL, int[] arrR) {
        int l = 0, i = 0, j = 0;
        while (l < arrL.length && j < arrR.length) {
            if (arrL[l] <= arrR[j]) {
                arr[i] = arrL[l]; 
                l++;
            } else {
                arr[i] = arrR[j]; 
                j++;
            }
            i++; 
        }
        if (l > arrL.length) {
            for(int k = j; k < arrR.length; k++) {
                arr[i] = arrR[k];
                i++;
            }
        }
        else { 
            for(int k = l; k < arrL.length; k++) {
                arr[i] = arrL[k];
                i++;
            }
        }
        if(i < arr.length) {
            for(int k = l; k < arrL.length; k++) {
                arr[i] = arrL[k];
                i++;
            }
            for(int k = j; k < arrR.length; k++) {
                arr[i] = arrR[k];
                i++;
            }
        }
    }
}