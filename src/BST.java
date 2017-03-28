public class BST {

    private LFU_BST_TreeNode root;

    BST() {
        root = null;
    }

    void insert(int key, int value) {

        root = insert(root,key,value);
    }

    LFU_BST_TreeNode insert(LFU_BST_TreeNode x, int key, int value) {

        if (x == null) {

            x = new LFU_BST_TreeNode(key, value,1);
            return x;
        }

        if (key > x.key) {

            x.right = insert(x.right, key, value);
        } else if (key < x.key) {

            x.left = insert(x.left, key, value);

        }else {

            x.key = key;
            x.value = value;
        }
        x.size = size(x.left)                                                                                                                            + size(x.right) + 1;
        return x;
    }

    void del(int key) {

        del(root, null, key);
    }

    void del(LFU_BST_TreeNode x, LFU_BST_TreeNode parent, int key) {

        if(x == null)
            return;

        if (key > x.key) {

            del(x.right, x, key);

        } else if (key < x.key) {

            del(x.left, x, key);
        }else {

            if (x.right != null) {

                LFU_BST_TreeNode min = delMin(x.right);

                if (parent == null) {

                    root = min;
                }
                else if (parent.left == x) {

                    parent.left = min;
                    parent.size--;
                } else  {

                    parent.right = min;
                    parent.size--;
                }
                min.left = x.left;
                if (min!=x.right) {
                    min.right = x.right;
                }
            } else {

                if (parent == null) {

                    if (x.left == null)
                        root = null;
                    else  {

                        root = x.left;
                        root.size = size(x.left);
                    }
                }else if (parent.left == x) {

                    parent.left = x.left;
                    parent.size--;
                } else  {

                    if (x.left!=null)
                        parent.right = x.left;
                    else
                        parent.right = null;
                    parent.size--;
                }

            }
            if (root !=null)
                root.size = size(root.left) + size(root.right);
        }
    }

    LFU_BST_TreeNode delMin(LFU_BST_TreeNode node) {

        if(node.left == null) {
            return node;
        }

        if (node.left.left == null) {

            LFU_BST_TreeNode min = node.left;
            node.left = null;
            if (min.right!=null) {
                node.left = min.right;
                min.right = null;
            }
            return min;
        } else {

            return delMin(node.left);
        }
    }

    int size() {

        return size(root);
    }

    int size(LFU_BST_TreeNode node) {

        if (node == null)
            return 0;

        return node.size;
    }
    LFU_BST_TreeNode get(int key) {

        return get(root,key);
    }

    LFU_BST_TreeNode get(LFU_BST_TreeNode x, int key) {

        if (x == null)
            return null;

        if (key == x.key) {

            return x;
        } else if (key > x.key) {

            return get(x.right,key);
        } else {

            return get(x.left,key);
        }

    }
}
