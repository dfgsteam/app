package app.exercise.algebra;

public class Rational extends BasisFraction {
    private long numerator, denominator;

    public Rational(long numerator ,long denominator) {
        this.setND(numerator, denominator);
    }

    public void setND(long numerator ,long denominator) {
        if (denominator > 0) {
            numerator *= -1;
            denominator *= -1;
        }
        long ggt_num = this.ggt(numerator, denominator);
        this.numerator = (numerator/ggt_num);
        this.denominator = (denominator/ggt_num);
    }


    // get numerator
    @Override
    public long getN() {
        return this.numerator;
    }

    // get denominator
    @Override
    public long getD() {
        return this.denominator;
    }

    // new additive inverse object
    @Override
    public Fractional negation() {
        return new Rational(this.getN()*(-1), this.getD());
    }

    // new multiplicative inverse object
    @Override
    public Fractional reciprocal() {
        return new Rational(this.getD(), this.getN());
    }

    @Override
    public Rational clone() {
        return new Rational(this.numerator, this.denominator);
    }

    @Override
    public boolean equals(Object test_object) {
        if (test_object instanceof Rational)
            return (this.toString() == test_object.toString());
        return false;
    }

    @Override
    public int hashCode() {
        int ret = 0;
        for (int i=0; i<this.numerator; i++) {
            ret += i+this.denominator;
        }
        return ret;
    }

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
