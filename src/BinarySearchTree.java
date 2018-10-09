/**
 * Name: Izzy Hurley
 * Lab Name: BinarySearchTree
 * Lab Purpose: The goal of BinarySearchTree is to create a program
 * Date: 10/3/18
 * Collaborators: None
 * ON MY HONOR: IH
 */

public class BinarySearchTree <Key extends Comparable<Key>, Value> {

    public Node<Key, Value> root;

    public BinarySearchTree() {
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {

        if (x.getLeft()==null&&x.getRight()==null){return 1;}
        else if (x.getLeft()!= null && x.getRight()==null){return size(x.getLeft())+1;}
        else if (x.getRight()!= null && x.getLeft()==null){return size(x.getRight())+1;}
        else if (x.getLeft()!= null && x.getRight()!= null){return size(x.getLeft())+1 +size(x.getRight());}
        else return 0;

    }

    public boolean isEmpty() {
        return (this.size()==0);
    }

    //recursive put wrapper
    public void put(Key key, Value value) {
        put(root, key, value);
    }

    //recursive put
    //sets left/right or creates a new node appropriately, returns the
    //modified node n
    private void put(Node<Key, Value> n, Key key, Value val) {
      Node x=  new Node(key,val,1);
      if (root == null){root = x;}
      else if ((x.getKey().compareTo(n.getKey())<0) && n.getLeft() == null){
        n.setLeft(x);
        }
        else if ((x.getKey().compareTo(n.getKey())>0) && n.getRight() == null){
            n.setRight(x);
        }
      else if (x.getKey().compareTo(n.getKey())==0){
            n.setValue(val);
        }
        else if (x.getKey().compareTo(n.getKey())<0){put(n.getLeft(),key,val);}
      else {put(n.getRight(),key,val);}
        //recurse on both sides 


    }

    //recursive get wrapper
    public Value get(Key key) {
        return get(root, key);
    }

    //recursive get
    //returns null if the key does not exist
    private Value get(Node<Key, Value> n, Key key) {
        if(n == null){
            return null;
        }
         else if (n.getKey().compareTo(key)==0){
            return n.getValue();
        }

       else if (n.getKey().compareTo(key)>=0){return get(n.getLeft(),key);}
        else {return get(n.getRight(),key);}
    }

    public boolean contains(Key key) {
        return get(key)!=null;
    }

    public Value remove(Key key) {
        Value v = get(key);
        root = remove(root, key);
        return v;
    }

    private Node remove(Node<Key, Value> n, Key key) {
        if(n == null) return null;
        int i = key.compareTo(n.getKey());
        if( i < 0) {
            n.setLeft(remove(n.getLeft(), key));
        } else if(i > 0) {
            n.setRight(remove(n.getRight(), key));
        }else {
            if(n.getRight() == null) return n.getLeft();
            if(n.getLeft() == null) return n.getRight();
            Node min = min(n.getRight());
            min.setLeft(n.getLeft());
            n = n.getRight();
        }
        n.setSize(size(n.getRight()) + size(n.getLeft()) + 1);
        return n;
    }

    public Key min() {
        return min(root).getKey();
    }

    //returns the node at the left most left branch of n
    private Node<Key, Value> min(Node<Key, Value> n) {
        if (n.getLeft()==null){return n;}
        else return min(n.getLeft());
    }

    public Key max() {
        return max(root).getKey();
    }

    //returns the node at the right most right branch of n
    private Node<Key, Value> max(Node<Key, Value> n) {
        if (n.getRight()==null){return n;}
        else return max(n.getRight());
    }

    public String toString() {
        String temp = toString(root);
        temp = temp.substring(0, temp.length()-2);
        return "{" + temp + "}";
    }

    private String toString(Node<Key, Value> n) {
        if(n == null) return "";
        return toString(n.getLeft()) +
                n.getKey() + "=" + n.getValue()  + ", " +
                toString(n.getRight());

    }}