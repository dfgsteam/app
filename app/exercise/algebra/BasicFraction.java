package app.exercise.algebra;

public abstract class BasicFraction implements Fractional {      //Hier wird die abstrakte Klasse definiert, die Fractional implementiert

    protected abstract void setND(long numerator, long denominator);

    @Override
    public void add(Fractional operand) {
        long new_numerator = (this.getN() * operand.getD()) + (this.getD() * operand.getN()); //definiere einen neuen numerator
        long new_denominator = this.getD() * operand.getD();                        //definiere einen neuen denominator
        this.setND(new_numerator, new_denominator);      //setze neu
    }

    @Override
    public void sub(Fractional operand) {
        this.add(operand.negation());       //negiere den Operanden und addiere
    }


    @Override
    public void mul(Fractional operand) {
        this.setND(operand.getN() * this.getN(), operand.getD() * this.getD());     //Multipliziere
    }

    @Override
    public void div(Fractional operand) {
        this.mul(operand.reciprocal());     //bilde Reziproken und multipliziere
    }

}