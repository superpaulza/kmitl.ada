import java.util.*;

public class Work8 {
    public static void main(String[] args) {
        int n = 7;
        int w = 35;
        int[] numbers = {5, 7, 10, 12, 15, 18, 20};
        /*Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: "); int n = sc.nextInt();
        int[] numbers = new int[n];
        System.out.print("Enter W: "); int w = sc.nextInt();
        System.out.print("Enter data (space for next): "); 
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }*/

        int[] sol = new int[numbers.length];

        //backtracking
        sumofsubset(numbers, w, 0, sol);
    }

    static void print(int[] sol, int[] numbers, int sum) {
        System.out.println("Sol: " + Arrays.toString(sol));
        System.out.println("Sum: " + sum);
        System.out.println("===================");
    }

    static void sumofsubset(int[] numbers, int w, int index, int[] sol) {
        sol[index] = -1;
        int n = numbers.length;
        while (sol[index] < 1) {
            sol[index] = sol[index] + 1;
            int sum = sum(index, sol, numbers);
            if (sum <= w && index == n - 1) {
                if(sum == w) {
                    print(sol, numbers, sum);
                }
            } else if (index < n - 1) {
                sumofsubset(numbers, w, index + 1, sol);
            }      
        }
  
    }
  
    static int sum(int index, int[] numbers, int[] sol) {
        int res = 0;
        for (int i = 0; i < sol.length; i++) {
                res += sol[i] * numbers[i];
        }
        return res;
    }
}