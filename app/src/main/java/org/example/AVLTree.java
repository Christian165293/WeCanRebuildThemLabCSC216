package org.example;

public class AVLTree {
    private Node root;

    // Insert a value into the AVL tree
    public void insert(int value) {
        root = insert(root, value);
    }

    // Recursive helper method to insert a value
    private Node insert(Node node, int value) {
        if (node == null) return new Node(value);

        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        } else {
            return node; // Duplicate values are not allowed
        }

        updateHeight(node);
        return balance(node);
    }

    // Delete a value from the AVL tree
    public void delete(int value) {
        root = delete(root, value);
    }

    // Recursive helper method to delete a value
    private Node delete(Node node, int value) {
        if (node == null) return null;

        if (value < node.value) {
            node.left = delete(node.left, value);
        } else if (value > node.value) {
            node.right = delete(node.right, value);
        } else {
            if (node.left == null || node.right == null) {

                node = (node.left != null) ? node.left : node.right;
            } else {
                Node temp = minValueNode(node.right);
                node.value = temp.value;
                node.right = delete(node.right, temp.value);
            }
        }

        if (node == null) return null;

        updateHeight(node);
        return balance(node);
    }

    // Find the node with the minimum value in a subtree
    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Update height of a node
    private void updateHeight(Node node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    // Get height of a node
    private int height(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    // Get balance factor of a node
    private int getBalance(Node node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    // Balance the tree
    private Node balance(Node node) {
        int balance = getBalance(node);

        // Left, Left Case
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }

        // Right, Right Case
        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node; // No balancing needed
    }

    // Right rotate subtree rooted with y
    private Node rightRotate(Node node) {
        Node newParent = node.left;
        Node T2 = newParent.right;

        newParent.right = node;
        node.left = T2;

        updateHeight(node);
        updateHeight(newParent);

        return newParent;
    }

    // Left rotate subtree rooted with x
    private Node leftRotate(Node node) {
        Node newParent = node.right;
        Node T2 = newParent.left;

        newParent.left = node;
        node.right = T2;

        updateHeight(node);
        updateHeight(newParent);

        return newParent;
    }

    // Get the root of the tree (for serialization/deserialization)
    public Node getRoot() {
        return root;
    }

    // Set the root of the tree (for deserialization)
    public void setRoot(Node root) {
        this.root = root;
    }

    // Print the tree (for testing purposes)
    public void printTree() {
        printTree(root, 0);
    }

    // Recursive helper method to print the tree
    private void printTree(Node node, int level) {
        if (node == null) return;

        printTree(node.right, level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
        System.out.println(node.value);
        printTree(node.left, level + 1);
    }
}

