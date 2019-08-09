package data;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {
    private TreeNode<T> root;
    private List<TreeNode<T>> leafs;

    public Tree() {
        root = new TreeNode(0, this);
        leafs = new ArrayList<>();
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public List<TreeNode<T>> getLeafs() {
        return leafs;
    }

    public TreeNode<T> newNode(T content) {
        return new TreeNode(content, this);
    }

    public List<List<T>> allBranches() {
        List<List<T>> result = new ArrayList<>(leafs.size());
        for (TreeNode<T> leaf : leafs) {
            List<T> branch = new ArrayList<>();
            TreeNode<T> node = leaf;
            while(node.getParent() != null) {
                branch.add(node.getContent());
                node = node.getParent();
            }
            result.add(branch);
        }
        return result;
    }
}


