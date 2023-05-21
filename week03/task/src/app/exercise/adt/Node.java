package app.exercise.adt;
import app.exercise.visualtree.*;

/**
 * Die Node-Klasse implementiert das DrawableTreeElement-Interface und repräsentiert einen Knoten in einem Baum.
 * @author Julius Hunold
 * Georg-August-Universität in Göttingen
 * @version v1.0
 * 
 * @param <T> der Typ des Werts, der vom Knoten gehalten wird (muss Comparable sein)
 */
public class Node<T extends Comparable<T>> implements DrawableTreeElement<T> {

    private T value;
    private Node<T> left;
    private Node<T> right;
    private Node<T> parent;

    /**
     * Konstruiert einen leeren Knoten.
     */
    public Node() {
        value = null;
        left = right = parent = null;
    }

    /**
     * Konstruiert einen Knoten mit dem angegebenen Wert.
     *
     * @param value der Wert des Knotens
     */
    public Node(T value) {
        this();
        this.value = value;
    }

    /**
     * Konstruiert einen Knoten mit dem angegebenen Wert, einem Kindknoten und einer Richtung.
     *
     * @param value der Wert des Knotens
     * @param node  der Kindknoten
     * @param left  true, wenn der Kindknoten links steht, false, wenn er rechts steht
     */
    public Node(T value, Node<T> node, boolean left) {
        this(value);
        if (left)
            this.left = node;
        else
            right = node;
    }

    /**
     * Konstruiert einen Knoten mit dem angegebenen Wert, einem linken und einem rechten Kindknoten.
     *
     * @param value der Wert des Knotens
     * @param left  der linke Kindknoten
     * @param right der rechte Kindknoten
     */
    public Node(T value, Node<T> left, Node<T> right) {
        this(value, left, true);
        this.right = right;
    }

    /**
     * Konstruiert einen Knoten mit dem angegebenen Wert, einem linken und einem rechten Kindknoten sowie einem Elternknoten.
     *
     * @param value  der Wert des Knotens
     * @param left   der linke Kindknoten
     * @param right  der rechte Kindknoten
     * @param parent der Elternknoten
     */
    public Node(T value, Node<T> left, Node<T> right, Node<T> parent) {
        this(value, left, right);
        this.parent = parent;
    }

    //------------------------------------------------------------------------------------------------------------------

    /**
     * Gibt den linken Kindknoten dieses Knotens zurück.
     *
     * @return der linke Kindknoten
     */
    @Override
    public Node<T> getLeft() {
        return left;
    }

    /**
     * Gibt den rechten Kindknoten dieses Knotens zurück.
     *
     * @return der rechte Kindknoten
     */
    @Override
    public Node<T> getRight() {
        return right;
    }

    /**
     * Überprüft, ob der Knoten rot ist.
     *
     * @return true, wenn der Knoten rot ist, andernfalls false
     */
    @Override
    public boolean isRed() {
        return Math.random() < 0.5;
    }

    /**
     * Gibt den Wert zurück, der von diesem Knoten gehalten wird.
     *
     * @return der Wert des Knotens
     */
    @Override
    public T getValue() {
        return value;
    }

    /**
     * Gibt den Elternknoten dieses Knotens zurück.
     *
     * @return der Elternknoten
     */
    public Node<T> getParent() {
        return parent;
    }

    /**
     * Setzt den Wert dieses Knotens.
     *
     * @param value der neue Wert für den Knoten
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Setzt den linken Kindknoten dieses Knotens.
     *
     * @param left der neue linke Kindknoten
     */
    public void setLeft(Node<T> left) {
        this.left = left;
    }

    /**
     * Setzt den rechten Kindknoten dieses Knotens.
     *
     * @param right der neue rechte Kindknoten
     */
    public void setRight(Node<T> right) {
        this.right = right;
    }

    /**
     * Setzt den Elternknoten dieses Knotens.
     *
     * @param parent der neue Elternknoten
     */
    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    /**
     * Erzeugt eine Kopie dieses Knotens.
     *
     * @return eine Kopie des Knotens
     */
    public Node<T> copyOf() {
        return new Node(value, left, right, parent);
    }
}
