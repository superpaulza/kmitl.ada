import java.util.Scanner;
public class Work1 {
    public static int count = 0;
    public static void main(String[] args) {
        System.out.print("Number of disks = ");
        int n = new Scanner(System.in).nextInt();
        System.out.println("============\n"+ "Moves: " + MOVE(n, 'A', 'B', 'C') + " times ( 2^" + n + " - 1 = " + (int)(Math.pow(2,n) - 1) + " )");
    }

    public static int MOVE(int n, char from, char to, char aux) {
        if(n==1) { 
            System.out.println("Move Disk 1 from " + from + " to " + to);
            count++;
        }
        else {
            MOVE(n-1,'A','C','B');
            System.out.println("Move Disk " + n + " from " + from +" to "+ to);
            count++;
            MOVE(n-1,'C','B','A');
        }
        return count;
    }
}
