package dictionary;

/*
 * @author Tabetha Boushey and Kelsey O'Keefe
 * @version 4/2/2012
 * Out Lab 5
 */

public class TreeNode {
    String[] dataArray;
    String data, definition;
    TreeNode parent;
    TreeNode left;
    TreeNode right;
    protected int column;
    protected int row;
    protected int center;

    public TreeNode(String word, String in_definition) {
        data = word;
        definition = in_definition;
        dataArray = word.split("");
        parent = null;
        left = null;
        right = null;
    }

    public String getData() {
        return data;
    }

    public String printData() {
        String printData = (data + ": " + definition);
        return printData;
    }

    public String getDefinition() {
        return definition;
    }

    public void setParent(TreeNode n) {
        parent = n;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setLeft(TreeNode n) {
        left = n;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setRight(TreeNode n) {
        right = n;
    }

    public TreeNode getRight() {
        return right;
    }

    public TreeNode searchFrom(String word) {
        String[] wordArray = word.split("");
            if (word.equalsIgnoreCase(data)) {
                return this;
            } else {
                for (int j = 0; j <= wordArray.length; j++) {
                    if (wordArray[j].hashCode() < dataArray[j].hashCode()) {
                        if (left == null) {
                            return null;
                        }
                        return left.searchFrom(word);
                    } else if (wordArray[j].hashCode() > dataArray[j].hashCode()) {
                        if (right == null) {
                            return null;
                        }
                        return right.searchFrom(word);
                    }
                }
            }
        return null;
    }

    public boolean searchForNode(TreeNode searchNode) {
        if (this == searchNode) {
            return true;
        }
        if (left != null && left.searchForNode(searchNode)) {
            return true;
        }
        if (right != null && right.searchForNode(searchNode)) {
            return true;
        }
        return false;
    }

    public int findMaxDepth() {
        int leftMax = 0;
        int rightMax = 0;
        if (left != null) {
            leftMax = left.findMaxDepth();
        }
        if (right != null) {
            rightMax = right.findMaxDepth();
        }
        return 1 + Math.max(leftMax, rightMax);
    }

    public String toString() {
        return "(" + dataArray + ")";
    }
}
