package app.exercise.algebra;
/**
 * Rational ist tendeziell die Hauptklasse des Projekts, die auch die Attribute enthält
 * Rational erbt von BasicFraction
 * @author Julius Hunold
 * Georg-August-Universität in Göttingen
 * @version v1.0
 */
public class Rational extends BasisFraction {
    private long numerator, denominator;

    /**
     * Konstruktor, der den Bruch initialisiert
     *
     * @param numerator der Zähler des Bruchs
     * @param denominator der Nenner des Bruchs
     */
    public Rational(long numerator ,long denominator) {
        this.setND(numerator, denominator);
    }

    /**
     * Setzt den Zähler und Nenner des Bruchs und kürzt ihn.
     *
     * @param numerator der neue Zähler
     * @param denominator der neue Nenner
     */
    public void setND(long numerator ,long denominator) {
        if (denominator > 0) {
            numerator *= -1;
            denominator *= -1;
        }
        long ggt_num = this.ggt(numerator, denominator);
        this.numerator = (numerator/ggt_num);
        this.denominator = (denominator/ggt_num);
    }

    /**
     * Gibt den Zähler des Bruchs zurück
     *
     * @return der Zähler
     */
    @Override
    public long getN() {
        return this.numerator;
    }

    /**
     * Gibt den Nenner des Bruchs zurück
     *
     * @return der Nenner
     */
    @Override
    public long getD() {
        return this.denominator;
    }

    /**
     * Gibt das additive Inverse des Bruchs zurück
     *
     * @return das additive Inverse
     */
    @Override
    public Fractional negation() {
        return new Rational(this.getN()*(-1), this.getD());
    }

    /**
     * Gibt das multiplikative Inverse des Bruchs zurück
     *
     * @return das multiplikative Inverse
     */
    @Override
    public Fractional reciprocal() {
        return new Rational(this.getD(), this.getN());
    }

    /**
     * Erstellt eine Kopie des aktuellen Bruchs
     *
     * @return eine Kopie des aktuellen Bruchs
     */
    @Override
    public Rational clone() {
        return new Rational(this.numerator, this.denominator);
    }

    /**
     * Überprüft, ob das übergebene Objekt dem aktuellen Bruch entspricht
     *
     * @param test_object das zu testende Objekt
     * @return true, wenn das Objekt dem Bruch entspricht, false sonst
     */
    @Override
    public boolean equals(Object test_object) {
        if (test_object instanceof Rational)
            return (this.toString() == test_object.toString());
        return false;
    }

    /**
     * Gibt den Hash-Code des Bruchs zurück
     *
     * @return der Hash-Code des Bruchs
     */
    @Override
    public int hashCode() {
        int ret = 0;
        for (int i=0; i<this.numerator; i++) {
            ret += i+this.denominator;
        }
        return ret;
    }

    /**
     * Gibt eine String-Repräsentation des Bruchs zurück
     *
     * @return eine String-Repräsentation des Bruchs
     */
    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }


    private long ggt(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
