package app.exercise.algebra;

public abstract class BasisFraction implements Fractional {
    protected abstract void setND(long numerator ,long denominator);

    @Override
    public void add(Fractional operand) {
        long new_num = this.getN()*operand.getD()+this.getD()*operand.getN(); // Erstellt neuen numerator
        long new_den = this.getD()*operand.getD(); // Erstellt neuen denominator
        this.setND(new_num, new_den);
    }

    // add operand to object
    @Override
    public void sub(Fractional operand) {
        this.add(operand.negation());
    }
    
    // multiply object by operand 
    @Override
    public void mul(Fractional operand) {
        this.setND(this.getN()*operand.getN(), this.getD()*operand.getD());
    }

    // divide object by operand 
    @Override
    public void div(Fractional operand) {
        this.mul(operand.reciprocal());
    }

    // // new additive inverse object
    // Fractional negation() {
    //     Fractional ret = new Fractional();
    //     ret.setND(this.getN()*(-1), this.getD());
    //     return ret;
    // }

    // // new multiplicative inverse object
    // Fractional reciprocal() {
    //     Fractional ret = new Fractional();
    //     ret.setND(this.getD(), this.getN());
    //     return ret;
    // }
}
