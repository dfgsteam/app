package app.exercise.algebra;
/**
 * Interface für die Implementierung von Rationalen Zahlen
 * @author Julius Hunold
 * Georg-August-Universität in Göttingen
 * @version v1.0
 */
public interface Fractional {

    /**
     * Gibt den Zähler des Bruchs zurück.
     *
     * @return der Zähler des Bruchs
     */
    public long getN();

    /**
     * Gibt den Nenner des Bruchs zurück.
     *
     * @return der Nenner des Bruchs
     */
    public long getD();

    /**
     * Addiert einen Bruch zu diesem Bruch.
     *
     * @param operand der Bruch, der zu diesem Bruch addiert werden soll.
     */
    public void add(Fractional operand);

    /**
     * Subtrahiert einen Bruch von diesem Bruch.
     *
     * @param operand der Bruch, der von diesem Bruch subtrahiert werden soll.
     */
    public void sub(Fractional operand);

    /**
     * Multipliziert diesen Bruch mit einem anderen Bruch.
     *
     * @param operand der Bruch, mit dem dieser Bruch multipliziert werden soll.
     */
    public void mul(Fractional operand);

    /**
     * Dividiert diesen Bruch durch einen anderen Bruch.
     *
     * @param operand der Bruch, durch den dieser Bruch dividiert werden soll.
     */
    public void div(Fractional operand);

    /**
     * Gibt den additiven Inversen dieses Bruchs zurück.
     *
     * @return der additiven Inverse dieses Bruchs
     */
    public Fractional negation ();

    /**
     * Gibt den multiplikativen Inversen dieses Bruchs zurück.
     *
     * @return der multiplikativen Inverse dieses Bruchs
     */
    public Fractional reciprocal ();
}
