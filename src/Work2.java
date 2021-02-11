import java.util.*;
public class Work2 {
    public static int count = 0;
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int MAX = 100;
        int[] arr = new int[MAX];
        Random(arr,0,50);
        arr[0] = 9; arr[arr.length-1] = 9;
        int ans[] = FindMinMax(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Max = " + ans[0] + "\nMin = " + ans[1] + "\nNumber of compare: " + count + " times. ( " + MAX + " - 1 = " + (MAX-1) + " )");
        long stop = System.currentTimeMillis();
        System.out.println("Time Usage = " + (stop-start) + " ms.");
    }

    public static void Random(int[] arr, int min, int max) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*(max - min + 1) + min);
        }
    }

    public static int[] FindMinMax(int[] arr) {
        if(arr.length == 2) {
            count++;
            if(arr[0] > arr[1]) {
                int[] ans = {arr[0], arr[1]};
                return ans;
            }
            else {
                int[] ans = {arr[1], arr[0]};
                return ans;
            }
        }
        else if(arr.length == 3) {
            count++;
            int ans[] = FindMinMax(Arrays.copyOfRange(arr, 0, 2));
            if(ans[0] < arr[2] && arr[2] > ans[1]) {
                ans[0] = arr[2];
                return ans;
            }
            else if(ans[1] > arr[2]) {
                ans[1] = arr[2];
                return ans;
            }
            else return ans;
        }
        else {
            //store min, max from each array
            int[] ans = {0,0};
            int[] ans2 = {0,0};
            //
            int m = (int) (Math.ceil(arr.length/2));
            ans = FindMinMax(Arrays.copyOfRange(arr, 0, m));
            ans2 = FindMinMax(Arrays.copyOfRange(arr, m, arr.length));
            //Find Min, Max from each array
            int max = 0, min = 0;
            if(ans[0] > ans2[0]) max = ans[0];
            else max = ans2[0];
            if(ans[1] < ans2[1]) min = ans[1];
            else  min = ans2[1];
            ans[0] = max; ans[1] = min;
            count++;
            //
            return ans;
        }
    }
}