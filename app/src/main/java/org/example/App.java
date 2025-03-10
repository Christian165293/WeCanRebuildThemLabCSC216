/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

public class App {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        Serializer serializer = new Serializer();
        Deserializer deserializer = new Deserializer();

        // Insert values
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);

        // Print the tree
        System.out.println("AVL Tree after insertion:");
        tree.printTree();

        // Serialize the tree
        String serialized = serializer.serialize(tree.getRoot());
        System.out.println("\nSerialized Tree: " + serialized);

        // Deserialize the tree
        AVLTree newTree = new AVLTree();
        newTree.setRoot(deserializer.deserialize(serialized));
        System.out.println("\nDeserialized Tree:");
        newTree.printTree();

        // Delete a value
        newTree.delete(6);
        System.out.println("\nTree after deleting 6:");
        newTree.printTree();
    }
}
