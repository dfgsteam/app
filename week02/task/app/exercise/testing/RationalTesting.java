package app.exercise.testing;
import app.exercise.algebra.Rational;

public class RationalTesting{
    
    public static void main(String[] args){

        Rational x = new Rational(Long.parseLong(args[0]), Long.parseLong(args[1]));
        Rational y = new Rational(Long.parseLong(args[2]), Long.parseLong(args[3]));

        System.out.println("x: "+ x);
        System.out.println("y: "+ y);

        System.out.println("x.hashcode(): "+ x.hashCode());
        System.out.println("y.hashcode(): "+ y.hashCode());

        System.out.println("x.equals(y): "+ x.equals(y));
        System.out.println("y.equals(x): "+ y.equals(x));

        System.out.println("x.getN(): "+ x.getN());
        System.out.println("y.getN(): "+ y.getN());

        System.out.println("x.getD(): "+ x.getD());
        System.out.println("y.getD(): "+ y.getD());

        System.out.println("x.negation(): "+ x.negation());
        System.out.println("y.negation(): "+ y.negation());

        System.out.println("x.reciprocal(): "+ x.reciprocal());
        System.out.println("y.reciprocal(): "+ y.reciprocal());


        x.mul(y);y.mul(x);
        System.out.println("x.mul(y): "+ x);
        System.out.println("y.mul(x): "+ y);

        x.div(y);y.div(x);
        System.out.println("x.div(y): "+ x);
        System.out.println("y.div(x): "+ y);

        x.add(y);y.add(x);
        System.out.println("x.add(y): "+ x);
        System.out.println("y.add(x): "+ y);

        x.sub(y);y.sub(x);
        System.out.println("x.sub(y): "+ x);
        System.out.println("y.sub(x): "+ y);

        System.out.println("x.clone(): "+ x.clone());
        System.out.println("y.clone(): "+ y.clone());
    }
}