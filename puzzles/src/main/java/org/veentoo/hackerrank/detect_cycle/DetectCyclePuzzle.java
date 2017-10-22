package org.veentoo.hackerrank.detect_cycle;

import java.util.HashSet;

/**
 * @author Alexey Nagornov
 */
public class DetectCyclePuzzle {

    HashSet<Node> nodes = new HashSet<>();

    boolean hasCycle(Node head) {
        if (nodes.contains(head)) {
            return true;
        }
        if (head == null || head.next == null) {
            return false;
        } else {
            nodes.add(head);
            return hasCycle(head.next);
        }
    }

    class Node {
        int data;
        Node next;
    }
}
