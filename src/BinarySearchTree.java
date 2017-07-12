import java.util.Scanner;

// Java program to demonstrate insert operation in binary search tree
class BinarySearchTree {

    class Node {
        int key;
        Node left,right;
        public Node(int key)
        {
            this.key=key;
            left=right=null;
        }
    }

    Node root;

    BinarySearchTree(){
        root=null;
    }


    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String choose="y";
        while(choose.equals("y"))
        {
            BinarySearchTree tree=new BinarySearchTree();
            System.out.println("Enter the number of elemenets in tree");
            int n=sc.nextInt();

            for(int i=0;i<n;i++)
            {
                int key=sc.nextInt();
                tree.insert(key);
            }

            System.out.println("TREE CREATION COMPLETE");

            tree.inOrder();
            tree.preOrder();
            tree.postOrder();
            //tree.levelorder();


            System.out.println();
            System.out.println("You want to create new tree? y/n");
            choose=sc.next();

        }
    }

    private void levelorder() {
        System.out.println();
        System.out.println("Level order traversal is ");
        levelOrderRec(root);
    }

    private void levelOrderRec(Node root) {
        if(root!=null)
        {
            System.out.print(root.key+" "+root.left+" "+root.right);
            levelOrderRec(root.left);
            levelOrderRec(root.right);

        }
    }

    private void postOrder() {
        System.out.println();
        System.out.println("Postorder traversal is ");
        postOrderRec(root);
    }

    private void postOrderRec(Node root) {
        if(root!=null)
        {
            preOrderRec(root.left);
            preOrderRec(root.right);
            System.out.print(root.key+" ");

        }
    }

    private void preOrder() {
        System.out.println();
        System.out.println("Preorder traversal is ");
        preOrderRec(root);
    }

    private void preOrderRec(Node root) {
        if(root!=null)
        {
            System.out.print(root.key+" ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    private void inOrder() {
        System.out.println();
        System.out.println("Inorder traversal is");
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if(root!=null){
            inOrderRec(root.left);
            System.out.print(root.key+" ");
            inOrderRec(root.right);

        }
    }

    private void insert(int key) {
        root=insertRec(root,key);
    }

    private Node insertRec(Node root, int key) {

        if(root==null){
            root=new Node(key);
        }


        if(key<root.key){
            root.left=insertRec(root.left,key);

        }else if(key>root.key){
            root.right=insertRec(root.right, key);

        }


        return root;
    }


}