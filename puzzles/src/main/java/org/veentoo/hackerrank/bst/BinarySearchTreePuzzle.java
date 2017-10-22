package org.veentoo.hackerrank.bst;

/**
 * @author Alexey Nagornov
 */
public class BinarySearchTreePuzzle {

    boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkBST(Node node, int min, int max) {
        return node == null
                || min < node.data && node.data < max
                && checkBST(node.left, min, node.data) && checkBST(node.right, node.data, max);
    }

}