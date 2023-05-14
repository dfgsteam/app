package app.exercise.algebra;

/**
 * Eine abstrakte Klasse, die das Fractional-Interface implementiert und Methoden für Bruchrechnungen bereitstellt.
 * @author Julius Hunold
 * Georg-August-Universität in Göttingen
 * @version v1.0
 */
public abstract class BasisFraction implements Fractional {

    /**
     * Eine abstrakte Methode, die den Zähler und den Nenner des Bruchs setzt.
     *
     * @param numerator der neue Zähler
     * @param denominator der neue Nenner
     */
    protected abstract void setND(long numerator ,long denominator);

    /**
     * Addiert einen Bruch zu diesem Bruch.
     *
     * @param operand der Bruch, der zu diesem Bruch addiert werden soll.
     */
    @Override
    public void add(Fractional operand) {
        long new_num = this.getN()*operand.getD()+this.getD()*operand.getN(); // Erstellt neuen numerator
        long new_den = this.getD()*operand.getD(); // Erstellt neuen denominator
        this.setND(new_num, new_den);
    }

    /**
     * Subtrahiert einen Bruch von diesem Bruch.
     *
     * @param operand der Bruch, der von diesem Bruch subtrahiert werden soll.
     */
    @Override
    public void sub(Fractional operand) {
        this.add(operand.negation());
    }
    
    /**
     * Multipliziert diesen Bruch mit einem anderen Bruch.
     *
     * @param operand der Bruch, mit dem dieser Bruch multipliziert werden soll.
     */
    @Override
    public void mul(Fractional operand) {
        this.setND(this.getN()*operand.getN(), this.getD()*operand.getD());
    }

    /**
     * Dividiert diesen Bruch durch einen anderen Bruch.
     *
     * @param operand der Bruch, durch den dieser Bruch dividiert werden soll.
     */
    @Override
    public void div(Fractional operand) {
        this.mul(operand.reciprocal());
    }
}
