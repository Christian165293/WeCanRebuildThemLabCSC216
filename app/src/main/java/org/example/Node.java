package org.example;

public class Node {
    int value;
    Node left;
    Node right;
    int height;

    Node(int value) {
        this.value = value;
        this.height = 1; // New node is initially added at leaf level
    }
}
