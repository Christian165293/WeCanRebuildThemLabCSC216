/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void testSerializeAndDeserialize() {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);

        Serializer serializer = new Serializer();
        String serialized = serializer.serialize(tree.getRoot());

        Deserializer deserializer = new Deserializer();
        Node root = deserializer.deserialize(serialized);

        AVLTree newTree = new AVLTree();
        newTree.setRoot(root);

        // Check if the deserialized tree matches the original tree
        assertEquals(20, newTree.getRoot().value);
        assertEquals(10, newTree.getRoot().left.value);
        assertEquals(30, newTree.getRoot().right.value);
    }
}
