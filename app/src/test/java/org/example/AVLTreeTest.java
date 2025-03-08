package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AVLTreeTest {

    @Test
    void testInsert() {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);

        // Check if the tree is balanced after insertion
        assertEquals(20, tree.getRoot().value);
        assertEquals(10, tree.getRoot().left.value);
        assertEquals(30, tree.getRoot().right.value);
    }

    @Test
    void testDelete() {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.delete(20);

        // Check if the tree is balanced after deletion
        assertEquals(30, tree.getRoot().value);
        assertEquals(10, tree.getRoot().left.value);
        assertNull(tree.getRoot().right);
    }

    @Test
    void testBalanceAfterInsertion() {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);

        // Check if the tree is balanced after multiple insertions
        assertEquals(20, tree.getRoot().value);
        assertEquals(10, tree.getRoot().left.value);
        assertEquals(40, tree.getRoot().right.value);
        assertEquals(30, tree.getRoot().right.left.value);
        assertEquals(50, tree.getRoot().right.right.value);
    }

    @Test
    void testBalanceAfterDeletion() {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.delete(10);

        // Check if the tree is balanced after deletion
        assertEquals(40, tree.getRoot().value);
        assertEquals(20, tree.getRoot().left.value);
        assertEquals(50, tree.getRoot().right.value);
        assertEquals(30, tree.getRoot().left.right.value);
    }
}