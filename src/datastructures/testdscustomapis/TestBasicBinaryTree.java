package datastructures.testdscustomapis;

import java.util.Stack;
import datastructures.basics.BasicBinaryTree;

public class TestBasicBinaryTree {

	public static void main(String[] args)
    {
        BasicBinaryTree<Integer> tree = new BasicBinaryTree<Integer>();
 
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
        tree.add(50);
        tree.add(30);
        tree.add(20);
        tree.add(40);
        tree.add(70);
        tree.add(60);
        tree.add(80);
 
        System.out.println(
            "Inorder traversal of the given tree");
        tree.inorder();
        
        tree.add(35);
        
        System.out.println(
                "\nInorder traversal of the given tree");
            tree.inorder();
            
        System.out.println("\ntree.contains(35): "+tree.contains(35));
 
        /*System.out.println("\nDelete 20");
        tree.deleteKey(20);
        System.out.println(
            "Inorder traversal of the modified tree");
        tree.inorder();
 
        System.out.println("\nDelete 30");
        tree.deleteKey(30);
        System.out.println(
            "Inorder traversal of the modified tree");
        tree.inorder();
 
        System.out.println("\nDelete 50");
        tree.deleteKey(50);
        System.out.println(
            "Inorder traversal of the modified tree");
        tree.inorder();*/
        String S = new String("abc");
        char[] charArr = S.toCharArray();
        Stack<Character> charStack = new Stack<Character>();
        for(int i=0; i< charArr.length; i++){
            charStack.push(charArr[i]);
        }
        //charStack.pop();
        StringBuilder sb = null;
        System.out.println(charStack.toString());
        charStack.isEmpty();
        boolean s = charStack.capacity() == 45 ? true: false;
        
    }

}
