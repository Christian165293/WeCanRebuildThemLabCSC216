package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Deserializer {
    // Deserialize a string into an AVL tree
    public Node deserialize(String str) {
        String[] nodes = str.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));
        return deserializeHelper(queue);
    }

    // Recursive helper method for deserialization
    private Node deserializeHelper(Queue<String> queue) {
        String val = queue.poll();
        if (val == null || val.equals("nill")) {
            return null; // Null node
        }

        Node node = new Node(Integer.parseInt(val));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
    }
}
