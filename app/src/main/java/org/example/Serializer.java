package org.example;

public class Serializer {
    // Serialize the AVL tree into a comma-separated string
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    // Recursive helper method for serialization
    private void serializeHelper(Node node, StringBuilder sb) {
        if (node == null) {
            sb.append("nill,"); // Use '#' to represent a null node
            return;
        }

        sb.append(node.value).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }
}
