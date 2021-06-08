import java.util.*;

class Subset {
    int numbers[];
    int sum;

    Stack<Integer> sol;

    Subset(int numbers[], int sum) {
        this.numbers = numbers;
        this.sum = sum;
        this.sol = new Stack<>();
    }

    public void solve(int s, int index) {
        if(s > sum) return;
        if(s == sum) {
            display();
            return;
        }
        for (int i = index; i < numbers.length; i++) {
            sol.push(numbers[i]);
            //System.out.println("i = " + i + " num = " + numbers[i]);
            solve(s+numbers[i],i+1);
            //System.out.println("In Stack: "+sol.toString());
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

public class Work8_3 {
    public static void main(String[] args) {
        /*int n = 7;
        int w = 35;
        int[] numbers = {5, 7, 10, 12, 15, 18, 20};*/
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: "); int n = sc.nextInt();
        int[] numbers = new int[n];
        System.out.print("Enter W: "); int w = sc.nextInt();
        System.out.print("Enter data (space for next): "); 
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        
        Subset ss = new Subset(numbers, w);
        ss.solve(0, 0);
    }
}
