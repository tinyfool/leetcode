/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.set(key,value);
 */


public class LFU_BST_TreeNode {

    int key;
    int value;
    LFU_BST_TreeNode left;
    LFU_BST_TreeNode right;
    int size;

    public LFU_BST_TreeNode(int key, int val, int size) {

        this.key = key;
        this.value = val;
        this.size = size;
    }
}
