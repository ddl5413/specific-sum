package data;

public class TreeNode<T> {
    private Tree tree;
    private T content;
    private TreeNode parent;
    private boolean hasChildren = false;

    public TreeNode (T content, Tree tree) {
        this.content = content;
        this.tree = tree;
    }

    public boolean addChildren(TreeNode child) {
        child.parent = this;
        if (!child.hasChildren) {
            tree.getLeafs().add(child);
        }
        this.hasChildren = true;
        return true;
    }

    public TreeNode getParent() {
        return parent;
    }

    public T getContent() {
        return content;
    }

    public Tree getTree() {
        return tree;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }
}
