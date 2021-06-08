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

public class Ans3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of worker: "); int n = sc.nextInt();
        System.out.print("Enter no. of job: "); int m = sc.nextInt();
        if(n != m) {
            System.out.print("no. of workers and jobs must equal!");
            return;
        }

        int[][] costMat = new int[n][m];
        for (int i = 0; i < costMat.length; i++) {
            for (int j = 0; j < costMat.length; j++) {
                System.out.print("Enter job [" + i +"]" + ", worker [" + j + "] : ");
                costMat[i][j] = sc.nextInt();
            }
        }
        /*int[] costMat = {{3,4,6},
                         {5,9,3},
                         {7,2,4}};*/
    }

    public static void findminCost(int[] costMat) {
        Queue<Node> queue = new LinkedList<>();
        
    }

}
