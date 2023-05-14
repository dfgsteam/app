package app.exercise.testing;
import app.exercise.algebra.Rational;

/**
* Die Klasse RationalTesting wird verwendet, um die Methoden der Rational-Klasse zu testen.
*/
public class RationalTesting{
    /**
    * Die main-Methode führt verschiedene Tests auf der Rational-Klasse aus.
    * @param args die Eingabeparameter für die Rationale-Objekte
    */
    public static void main(String[] args){
    // Erstelle zwei Rational-Objekte x und y aus den Eingabeparametern
    Rational x = new Rational(Long.parseLong(args[0]), Long.parseLong(args[1]));
    Rational y = new Rational(Long.parseLong(args[2]), Long.parseLong(args[3]));
    // Gib die Werte der Rational-Objekte x und y aus
    System.out.println("x: "+ x);
    System.out.println("y: "+ y);
    // Gib den Hashcode der Rational-Objekte x und y aus
    System.out.println("x.hashcode(): "+ x.hashCode());
    System.out.println("y.hashcode(): "+ y.hashCode());
    // Überprüfe, ob die Rational-Objekte x und y gleich sind
    System.out.println("x.equals(y): "+ x.equals(y));
    System.out.println("y.equals(x): "+ y.equals(x));
    // Gib den Zähler (Nenner) der Rational-Objekte x und y aus
    System.out.println("x.getN(): "+ x.getN());
    System.out.println("y.getN(): "+ y.getN());
    // Gib den Nenner (Zähler) der Rational-Objekte x und y aus
    System.out.println("x.getD(): "+ x.getD());
    System.out.println("y.getD(): "+ y.getD());
    // Gib die Negation (Gegenwert) der Rational-Objekte x und y aus
    System.out.println("x.negation(): "+ x.negation());
    System.out.println("y.negation(): "+ y.negation());
    // Gib den Kehrwert (Reziprok) der Rational-Objekte x und y aus
    System.out.println("x.reciprocal(): "+ x.reciprocal());
    System.out.println("y.reciprocal(): "+ y.reciprocal());
    // Multipliziere die Rational-Objekte x und y
    x.mul(y);y.mul(x);
    System.out.println("x.mul(y): "+ x);
    System.out.println("y.mul(x): "+ y);
    // Dividiere die Rational-Objekte x und y
    x.div(y);y.div(x);
    System.out.println("x.div(y): "+ x);
    System.out.println("y.div(x): "+ y);
    // Addiere die Rational-Objekte x und y
    x.add(y);y.add(x);
    System.out.println("x.add(y): "+ x);
    System.out.println("y.add(x): "+ y);
    // Subtrahiere die Rational-Objekte x und y
    x.sub(y);y.sub(x);
    System.out.println("x.sub(y): "+ x);
    System.out.println("y.sub(x): "+ y);
    // Klone die Rational-Objekte x und y
    System.out.println("x.clone(): "+ x.clone());
    System.out.println("y.clone(): "+ y.clone());
    }
}