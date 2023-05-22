package app.exercise.adt;
import app.exercise.algebra.*;
import java.util.*;

/**
 * Die BSTreeIterator-Klasse implementiert den Iterator für den BSTree.
 * @author Julius Hunold
 * Georg-August-Universität in Göttingen
 * @version v1.0
 */
public class BSTreeIterator<T extends Comparable> implements Iterator<T> {
    BSTree<T> tree;

    /**
     * Konstruktor für den BSTreeIterator.
     * Setzt den Iterator auf den Anfang des BSTree.
     *
     * @param tree der BSTree, für den der Iterator erstellt wird.
     */
    public BSTreeIterator(BSTree<T> tree) {
        this.tree = tree;
        tree.setRunning(tree.getRoot());
        while (tree.getRunning().getLeft() != null) {
            tree.setRunning(tree.getRunning().getLeft());
        }
    }

    /**
     * Überprüft, ob der Iterator ein weiteres Element hat.
     *
     * @return true, wenn der Iterator ein weiteres Element hat, ansonsten false.
     */
    @Override
    public boolean hasNext() {
        Node<T> running_node = tree.getRunning();
        if (running_node.getRight() == null) {
            if (running_node.getParent() != null && running_node.getValue().compareTo(running_node.getParent().getValue()) > 0)
                return false;
            else if (running_node.getParent() == null)
                return false;
        }
        return true;
    }

    /**
     * Gibt das nächste Element des Iterators zurück.
     *
     * @return das nächste Element des Iterators.
     */
    @Override
    public T next() {
        if (!hasNext())
            return null;
        Node<T> running_node = tree.getRunning();
        if (running_node.getRight() == null) {
            tree.setRunning(running_node.getParent());
            return running_node.getParent().getValue();
        }


        running_node = running_node.getRight();
        while (running_node.getLeft() != null)
            running_node = running_node.getLeft();

        tree.setRunning(running_node);
        return running_node.getValue();
    }
}

