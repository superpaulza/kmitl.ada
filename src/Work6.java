import java.util.*;

class Node {
    int weight[];
    int w;
    
    Stack<Integer> sol;
    
    Node(int weight[], int w) {
        this.weight = weight;
        this.w = w;
        this.sol = new Stack<>();
    }

    void solve(int s, int index) {   
        if(s > w)
            return;

        if(s == w) {
            display();
            return;
        }
    
        for(int i = index; i < weight.length; i++) {
            sol.push(weight[i]);
            solve(s + weight[i], i + 1);
            sol.pop();
        }
    }

    void display() {
        int sum = 0;
        String str = "";
        Object[] arr = sol.toArray();
        for (int i = 0; i < arr.length; i++) {
            sum += (int)arr[i];
            str += arr[i];
            if(i+1 < arr.length) str += " + ";
            else str += " = ";
        }
        System.out.println(str + sum);
    }
}

public class Work6 {
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Weight: "); int w = sc.nextInt();
        System.out.print("Enter number of data: "); int num = sc.nextInt();
        int[] weight = new int[num];
        System.out.print("Enter data (space for next): "); 
        for (int i = 0; i < num; i++) {
            weight[i] = sc.nextInt();
        }

        int[] sol = new int[weight.length];
        ArrayList<int[]> arr = new ArrayList<int[]>();

        //backtracking
        System.out.println("Solving by backtracking (Sum-of-Subset)");
        knapsack(weight, w, 0, sol, arr);
        System.out.println("Maximum Weight is " + max + ".");
        /*for (int i = 0; i < arr.size(); i++) {
            System.out.println("Answer is: ");
            String str = "";
            for (int j = 0; j < arr.get(i).length; j++) {
                str += arr.get(i)[j];
                if(j+1 < sol.length) str += " + ";
                else str += " =";
            }
            System.out.println("[" + (i+1) +"] : "+ str + " " + max);
        }*/
        System.out.println("Solving by backtracking (Efficiency SoS)");
        Node kns = new Node(weight, w);
        kns.solve(0,0);
    }

    static void knapsack(int[] weight, int w, int index, int[] sol, ArrayList<int[]> arr) {
        sol[index] = -1;
        int n = weight.length;
        while (sol[index] < 1) {
            sol[index] = sol[index] + 1;
            if (sum(index, sol, weight) <= w && index == n - 1) {
                System.out.println("Sol: " + Arrays.toString(sol));
                System.out.println("weight = " + sum(index, sol, weight));
                System.out.println("===================");
                update(sum(index, sol, weight), arr, sol);
            } else if (index < n - 1) {
                knapsack(weight, w, index + 1, sol, arr);
            }      
        }
  
    }
  
    static int sum(int index, int[] weight, int[] sol) {
        int res = 0;
        for (int i = 0; i < sol.length; i++) {
            if (sol[i] < 0 ) System.out.println("in sum: i = " + i + "   sol[i] = " + sol[i]);
            res += sol[i] * weight[i];
        }
        return res;
    }

    static void update(int res, ArrayList<int[]> arr, int[] sol) {
        if(max < res) {
            arr.clear();
            max = res;
            arr.add(sol);
        } else if (res == max) {
            arr.add(sol);
        }
    }
   
/*    static void knapsack2(int weight[], int sum, int index, int w) { 
        if (w == sum) { 
            if(index < weight.length) {
                knapsack2(weight, sum - weight[index-1], index, w);
            }
        } else { 
            for(int i = index; i < weight.length; i++) { 
                knapsack2(weight, sum + weight[i], i + 1, w);
            } 
        } 
    }*/
 
}