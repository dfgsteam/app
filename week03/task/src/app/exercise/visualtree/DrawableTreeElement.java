package app.exercise.visualtree;

/**
 * Das DrawableTreeElement-Interface definiert die Methoden, die von einem baumdarstellbaren Element implementiert werden müssen.
 * Es repräsentiert ein Element im Baum, das gezeichnet werden kann.
 * @author Julius Hunold
 * Georg-August-Universität in Göttingen
 * @version v1.0
 * 
 * @param <T> der Typ des Werts, der vom Element gehalten wird
 */
public interface DrawableTreeElement<T> {
    /**
     * Gibt das linke Kindelement dieses Elements zurück.
     *
     * @return das linke Kindelement
     */
    public DrawableTreeElement<T> getLeft();

    /**
     * Gibt das rechte Kindelement dieses Elements zurück.
     *
     * @return das rechte Kindelement
     */
    public DrawableTreeElement<T> getRight();

    /**
     * Überprüft, ob das Element rot ist.
     *
     * @return true, wenn das Element rot ist, andernfalls false
     */
    public boolean isRed();

    /**
     * Gibt den Wert zurück, der von diesem Element gehalten wird.
     *
     * @return der Wert des Elements
     */
    public T getValue();
}
