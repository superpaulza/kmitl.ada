import java.util.*;

public class Work6 {
    class TNode {
        int data;
        TNode parent = null, left = null, right = null;
        public TNode(int d) {
            data = d;
            parent = left = right = null;
        }
    }

    TNode root = null;

    void add(int d) {
        if(root == null) {
            root = new TNode(d);
        } else {
            addR(root, d);
        }
    }

    void addR(TNode p,int d){
        if(d < p.data){
            if(p.left == null)
            {
                p.left = new TNode(d);
                p.left.parent = p;
            }
            else addR(p.left,d);
        }
        else {
            if(p.right == null) {
                p.right = new TNode(d);
                p.right.parent = p;
            }
            else addR(p.right,d);
        }
    }

    //NLR
    void printPreOrder(TNode p) {
        if(p != null) {
            System.out.print(" " + p.data);
            printInOrder(p.left);
            printInOrder(p.right);
        }
    }

    //LRN
    void printPostOrder(TNode p) {
        printInOrder(p.left);
        printInOrder(p.right);
        System.out.print(" " + p.data);
    }

    //LNR
    void printInOrder(TNode p) {
        if(p != null) {
            printInOrder(p.left);
            System.out.print(" " + p.data);
            printInOrder(p.right);
        }
    }

    public static void main(String[] args) {
        Work6 tree = new Work6();
        //Scanner sc = new Scanner(System.in);
        /*System.out.print("Enter No: "); int num = sc.nextInt();
        while (num != 0) {
            tree.add(num % 10);
            num/=10;
        }*/
        tree.add(99);
        tree.add(11);
        tree.add(13);
        tree.add(24);
        tree.add(7);
        tree.add(19);
        System.out.println("== Tree Traversal ==");
        System.out.print("In Order: ");
        tree.printInOrder(tree.root);
        System.out.println();
        System.out.print("Pre Order: ");
        tree.printPreOrder(tree.root);
        System.out.println();
        System.out.print("Post Order: ");
        tree.printPostOrder(tree.root);
        System.out.println();
    }
}