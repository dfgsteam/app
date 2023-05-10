package app.exercise.algebra;

public class Rational extends app.exercise.algebra.BasicFraction {
    long numerator, denominator;

    public Rational(long numerator, long denominator) {
        this.setND(numerator, denominator);
    }

    private void setRight() {       //setze denominator positiv
        if (this.denominator < 0) {
            this.numerator *= -1;
            this.denominator *= -1;
        }
    }

    private long ggT(long numerator, long denominator) {
        if (denominator == 0) return numerator;
        return ggT(denominator, numerator % denominator);
    }

    @Override
    public String toString() {
        return "" + this.numerator + "/" + this.denominator;
    }

    @Override
    protected void setND(long numerator, long denominator) {
        long g = ggT(numerator, denominator);       //ggT finden
        this.numerator = numerator / g;             //Kürzen
        this.denominator = denominator / g;
        this.setRight();
        
    }

    @Override
    public long getD() {
        return this.denominator;        //Getter für denominator
    }

    @Override
    public long getN() {
        return this.numerator;          //Getter für Nominator
    }

    @Override
    public Fractional negation() {      //Negation mit return
        return new Rational(this.numerator*-1, this.denominator);
    }

    @Override
    public Fractional reciprocal() {        //Bilde Reciproke
        return new Rational(this.denominator, this.numerator);
    }

    @Override
    public Fractional clone() {
        return new Rational(this.getN(), this.getD());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Fractional) {
            Fractional tempr = (Fractional)obj;
            return tempr.getN() == this.getN() && tempr.getD() == this.getD();
        }
        return false;
    }

    @Override
    public int hashCode() {
        String hash = this.getN() + "" + this.getD() + "" + (Integer.toString((int)getN())).length();
        return Integer.parseInt(hash);
    }
}