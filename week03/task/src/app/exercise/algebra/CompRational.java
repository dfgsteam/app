package app.exercise.algebra;

/**
 * Die Klasse CompRational erweitert die Klasse Rational und implementiert das Comparable-Interface.
 * Sie repräsentiert eine rationale Zahl mit der Fähigkeit, mit anderen Objekten verglichen zu werden.
 * @author Julius Hunold
 * Georg-August-Universität in Göttingen
 * @version v1.0
 */
public class CompRational extends Rational implements Comparable {

    /**
     * Konstruiert ein CompRational-Objekt mit dem angegebenen Zähler und Nenner.
     *
     * @param numerator   der Zähler der rationalen Zahl
     * @param denominator der Nenner der rationalen Zahl
     */
    public CompRational(long numerator, long denominator) {
        super(numerator, denominator);
    }

    /**
     * Vergleicht dieses CompRational-Objekt mit dem angegebenen Objekt.
     *
     * @param o das zu vergleichende Objekt
     * @return eine negative ganze Zahl, 0 oder eine positive ganze Zahl, je nachdem ob dieses Objekt kleiner als,
     *         gleich oder größer als das angegebene Objekt ist
     */
    @Override
    public int compareTo(Object o) {
        if (o instanceof Fractional) {
            final Fractional fraction = (Fractional) o;
            if (this.equals(fraction))
                return 0;
            return (this.getN() / this.getD()) < fraction.getN() / fraction.getD() ? 1 : -1;
        }
        return 1;
    }
}
