package app.exercise.adt;
import java.util.*;

/**
 * Die BSTree-Klasse implementiert die AbstractCollection-Klasse und repräsentiert einen binären Suchbaum.
 * Sie speichert Elemente vom generischen Typ T, die das Comparable-Interface implementieren müssen.
 * @author Julius Hunold
 * Georg-August-Universität in Göttingen
 * @version v1.0
 */
public class BSTree<T extends Comparable<T>> extends AbstractCollection<T> {

    private Node<T> root;
    private Node<T> running;
    private int size;

    /**
     * Konstruiert einen BSTree mit dem angegebenen Wurzelknoten.
     *
     * @param root der Wurzelknoten des binären Suchbaums
     */
    public BSTree(Node<T> root) {
        this.root = root;
        running = root;
        size = 1;
    }

    /**
     * Gibt die Anzahl der Elemente im BSTree zurück.
     *
     * @return die Anzahl der Elemente im BSTree
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Überprüft, ob der BSTree das angegebene Element enthält.
     *
     * @param o das zu überprüfende Element
     * @return true, wenn der BSTree das Element enthält, andernfalls false
     */
    @Override
    public boolean contains(Object o) {
        if (!(o instanceof Node<?>))
            return false;

        Node<T> search = (Node<T>) o;

        if (running == null || root == null) {
            running = root;
            return false;
        }

        if (running.getValue().compareTo(search.getValue()) == 0) {
            return true;
        }

        if (running.getValue().compareTo(search.getValue()) < 0) {
            if (running.getRight() != null) {
                running = running.getRight();
                return contains(o);
            }
            running = root;
            return false;
        }

        if (running.getLeft() != null) {
            running = running.getLeft();
            return contains(o);
        }

        running = root;
        return false;
    }

    /**
     * Fügt das angegebene Element zum BSTree hinzu.
     *
     * @param element das hinzuzufügende Element
     * @return true, wenn das Element erfolgreich hinzugefügt wurde, andernfalls false
     */
    @Override
    public boolean add(T element) {
        int cond = running.getValue().compareTo((new Node<>(element)).getValue());
        if (cond == 0) {
            running = root;
            return false;
        }

        if (cond < 0) {
            if (running.getRight() != null) {
                running = running.getRight();
                return add(element);
            }
            running.setRight(new Node<>(element));
            running = root;
            size++;
            return true;
        }

        if (running.getLeft() != null) {
            running = running.getLeft();
            return add(element);
        }
        running.setLeft(new Node<>(element));
        running = root;
        size++;
        return true;
    }

    /**
     * Entfernt das angegebene Element aus dem BSTree, sofern es vorhanden ist.
     *
     * @param o das zu entfernende Element
     * @return true, wenn das Element erfolgreich entfernt wurde, andernfalls false
     */
    @Override
    public boolean remove(Object o) {
        if (!(o instanceof Node<?>))
            return false;

        Node<T> rem = (Node<T>) o;

        if (!this.contains(o))
            return false;

        while (running.getValue().compareTo(rem.getValue()) != 0) {
            if (running.getValue().compareTo(rem.getValue()) < 0)
                running = running.getRight();
            else
                running = running.getLeft();
        }

        if (running.getRight() == null && running.getLeft() == null) {
            if (running.getParent() == null) {
                root = running = null;
                return true;
            }

            Node<T> tmp = running.copyOf();
            running = running.getParent();
            if (running.getLeft().getValue().compareTo(tmp.getValue()) == 0)
                running.setLeft(null);
            else
                running.setRight(null);

            running = root;
            return true;
        }

        if (running.getRight() != null && running.getLeft() == null) {
            running.setValue(running.getRight().getValue());
            running.setLeft(running.getRight().getLeft());
            running.setRight(running.getRight().getRight());
            return true;
        }

        if (running.getRight() == null && running.getLeft() != null) {
            running.setValue(running.getLeft().getValue());
            running.setRight(running.getLeft().getRight());
            running.setLeft(running.getLeft().getLeft());
            return true;
        }

        Node<T> child = running.getRight();
        while (child.getLeft() != null)
            child = child.getLeft();

        running.setValue(child.getValue());
        if (child.getRight() != null) {
            child.setValue(child.getRight().getValue());
            child.setLeft(child.getRight().getLeft());
            child.setRight(child.getRight().getRight());
        } else {
            Node<T> par = child.getParent();
            if (child.getValue().compareTo(par.getRight().getValue()) != 0) {
                par.setLeft(null);
            } else
                par.setRight(null);
        }
        running = root;
        return true;
    }
    
    @Override
    public Iterator<T> iterator() {
        return null;
    }
}

