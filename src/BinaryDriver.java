/**
 * Name: Izzy Hurley
 * Lab Name: BinaryDriver
 * Lab Purpose: The goal of BinaryDriver is to create a program
 * Date: 10/4/18
 * Collaborators: None
 * ON MY HONOR: IH
 */

public class BinaryDriver {
public static boolean isBST(BinarySearchTree t){
       return isBST(t.root);
}
private static boolean isBST(Node current){
        if (current==null){return true;}
        else if (current.getLeft()==null && current.getRight()==null){return true;}
        else if (current.getRight()==null){return isBST(current.getLeft());}
        else if (current.getLeft()==null){return isBST(current.getRight());}
        else if (current.getLeft().getKey().compareTo(current.getRight().getKey())<0){return isBST(current.getRight())&&isBST(current.getLeft());}
        else return false;
}
    public static void main(String[] args) {
BinarySearchTree tree = new BinarySearchTree();
tree.put(1,"one");
tree.put(2, "two");
tree.put(5,"five");
        System.out.println("Put one,two,five on the tree and now call size expected result: 3");
        System.out.println(tree.size());

        System.out.println("get 1 expected result: one");
        System.out.println(tree.get(1));
        System.out.println("call max expected result: five");
        System.out.println(tree.max());
        System.out.println("call min expected result: one");
        System.out.println(tree.min());
            System.out.println("Call contains(2) expected result: true");
            System.out.println(tree.contains(2));
        System.out.println("removed 1,2,5 in order expected result: one two five");
        System.out.println(tree.remove(1));
        System.out.println(tree.remove(2));
        System.out.println(tree.remove(5));
        System.out.println("get 1 from empty tree expected result is null");
        System.out.println(tree.get(1));
        System.out.println("Put two,five,seven,one on the tree");
            tree.put(2, "two");
            tree.put(5,"five");
            tree.put(7,"seven");
            tree.put(1,"one");
            System.out.println("call toString method on tree expected result:{1=one, 2=two, 5=five, 7=seven}");
            System.out.println(tree.toString());
            System.out.println("Test isBST expected result: true");
            System.out.println(isBST(tree));
            System.out.println("change the first getLeft to four");
            tree.root.setLeft(new Node(4,"four",1));
            System.out.println("Test isBST expected result: false");
            System.out.println(isBST(tree));
            System.out.println("change the first getRight to one");
            tree.root.setRight(new Node(1,"one",1));
            System.out.println("Test isBST expected result: false");
            System.out.println(isBST(tree));





    }
}
