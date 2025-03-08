package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SerializerTest {

    @Test
    void testSerialize() {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);

        Serializer serializer = new Serializer();
        String serialized = serializer.serialize(tree.getRoot());

        // Check if the serialized string matches the expected output
        assertEquals("20,10,nill,nill,30,nill,nill,", serialized);
    }

    @Test
    void testSerializeEmptyTree() {
        AVLTree tree = new AVLTree();
        Serializer serializer = new Serializer();
        String serialized = serializer.serialize(tree.getRoot());

        // Check if the serialized string for an empty tree is correct
        assertEquals("nill,", serialized);
    }
}