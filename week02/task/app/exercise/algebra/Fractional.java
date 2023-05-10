package app.exercise.algebra;

public interface Fractional {
    // get numerator
    public long getN();
    // get denominator
    public long getD();
    // add operand to object
    public void add(Fractional operand);
    // subtract operand from object
    public void sub(Fractional operand);
    // multiply object by operand 
    public void mul(Fractional operand);  
    // divide object by operand 
    public void div(Fractional operand);
    // new additive inverse object
    public Fractional negation ();
    // new multiplicative inverse object
    public Fractional reciprocal ();
}
