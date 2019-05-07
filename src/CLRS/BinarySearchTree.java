package CLRS;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

class BSTNode {

    int key;
    BSTNode left;
    BSTNode right;
    BSTNode parent;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("===================\r\n");
        sb.append("key=").append(key).append("\r\n");
        if(parent!=null)
            sb.append("parent=").append(parent.key).append("\r\n");
        if(left!=null)
            sb.append("left=").append(left.key).append("\r\n");
        if(right!=null)
            sb.append("right=").append(right.key).append("\r\n");
        sb.append("===================\n");
        return sb.toString();
    }
}

public class BinarySearchTree {

    BSTNode root = null;
    void inorderWalk(BSTNode x) {
        if(x!=null) {
            inorderWalk(x.left);
            System.out.println(x.key);
            inorderWalk(x.right);
        }
    }

    BSTNode search(BSTNode x,int key){

        if(x==null || key==x.key)
            return x;
        if(key<x.key)
            return search(x.left,key);
        else
            return search(x.right,key);
    }

    BSTNode search2(BSTNode x,int key) {

        while (x!=null && key!=x.key) {
            if(key < x.key)
                x = x.left;
            else
                x = x.right;
        }
        return x;
    }

    void insert(int key) {

        BSTNode z = new BSTNode();
        z.key = key;
        insert(z);
    }

    void insert(BSTNode z) {

        BSTNode y = null;
        BSTNode x = root;
        while (x!=null) {

            y = x;
            if(z.key<x.key)
                x = x.left;
            else
                x = x.right;
        }
        z.parent = y;
        if (y==null)
            root = z;
        else if (z.key < y.key)
            y.left = z;
        else
            y.right = z;
    }

    BSTNode minimum(BSTNode x) {

        while (x.left!=null)
            x = x.left;
        return x;
    }

    BSTNode maximum(BSTNode x) {

        while (x.right !=null)
            x = x.right;
        return x;
    }

    BSTNode successor(BSTNode x) {

        if(x.right!=null)
            return minimum(x.right);
        BSTNode y = x.parent;
        while (y!=null && x==y.right) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    void transplant(BSTNode u,BSTNode v) {

        if (u.parent == null)
            root = v;
        else if (u == u.parent.left) {
            u.parent.left = v;
        }else
            u.parent.right = v;
        if (v!=null)
            v.parent = u.parent;
    }

    void delete(int key) {

        BSTNode z = search2(root,key);
        delete(z);
    }

    void delete(BSTNode z) {

        if (z.left == null)
            transplant(z,z.right);
        else if (z.right == null)
            transplant(z,z.left);
        else {

            BSTNode y = minimum(z.right);
            if (y.parent!=z) {
                transplant(y,y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z,y);
            y.left = z.left;
            y.left.parent = y;
        }

    }

    public static void main(String[] args){

        BinarySearchTree bst = new BinarySearchTree();
        bst.inorderWalk(bst.root);
        bst.insert(10);
        bst.insert(9);
        bst.insert(8);
        bst.insert(6);
        bst.insert(20);
        bst.insert(7);
        bst.inorderWalk(bst.root);
        System.out.println(bst.search2(bst.root,7));
        System.out.println(bst.search2(bst.root,9));

        System.out.println(bst.maximum(bst.root));
        System.out.println(bst.minimum(bst.root));

        System.out.println(bst.successor(bst.search2(bst.root,10)));
        System.out.println(bst.successor(bst.search2(bst.root,7)));
        bst.delete(6);
        bst.inorderWalk(bst.root);
        bst.delete(10);
        bst.inorderWalk(bst.root);

    }
}
