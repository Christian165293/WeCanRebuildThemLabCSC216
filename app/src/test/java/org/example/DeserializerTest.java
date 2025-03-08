package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeserializerTest {
    @Test
    void testDeserialize() {
        String serialized = "20,10,nill,nill,30,nill,nill,";
        Deserializer deserializer = new Deserializer();
        Node root = deserializer.deserialize(serialized);

        // Check if the deserialized tree matches the expected structure
        assertEquals(20, root.value);
        assertEquals(10, root.left.value);
        assertEquals(30, root.right.value);
        assertNull(root.left.left);
        assertNull(root.left.right);
        assertNull(root.right.left);
        assertNull(root.right.right);
    }

    @Test
    void testDeserializeEmptyTree() {
        String serialized = "nill,";
        Deserializer deserializer = new Deserializer();
        Node root = deserializer.deserialize(serialized);

        // Check if the deserialized tree is null (empty tree)
        assertNull(root);
    }
}