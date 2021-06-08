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

public class Work8_2 {
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

        Node kns = new Node(numbers, w);
        kns.solve(0,0);
    }
}