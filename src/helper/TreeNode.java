package helper;
import static org.junit.jupiter.api.Assertions.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        val = x;
    }

    public static boolean sameTree(TreeNode p,TreeNode q) {

        if(p==null&&q==null)
            return true;
        if(p==null||q==null)
            return false;
        if(p.val!=q.val)
            return false;
        return sameTree(p.left,q.left) && sameTree(p.right,q.right);
    }
}

