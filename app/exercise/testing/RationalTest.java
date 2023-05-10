package app.exercise.testing;
import app.exercise.algebra.*;

public class RationalTest {
    public static void main(String[] args) {
        Rational test_obj1 = new Rational(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
        Rational test_obj2 = new Rational(Integer.parseInt(args[2]),Integer.parseInt(args[3]));

        //getD() und getN()
        System.out.println("getN(): " + test_obj1.getN());
        System.out.println("getD(): " + test_obj1.getD());

        //toString() - Methode
        System.out.println("toString(): " + test_obj1);
        System.out.println("toString(): " + test_obj2);


        //Negation
        System.out.println("negation(): " + test_obj1.negation());
        System.out.println("negation(): " + test_obj2.negation());

        //Reciprocal
        System.out.println("reciprocal(): " + test_obj1.reciprocal());
        System.out.println("reciprocal(): " + test_obj2.reciprocal());

        //clone()
        System.out.println("clone(): " + test_obj1.clone());
        System.out.println("clone(): " + test_obj2.clone());

        //Addition
        test_obj1.add(test_obj2);
        System.out.println("add(): " + test_obj1);
        test_obj1.sub(test_obj2);
        test_obj2.add(test_obj1);
        System.out.println("add(): " + test_obj2);

        //Subtraktion
        test_obj2.sub(test_obj1);
        test_obj1.sub(test_obj2);
        System.out.println("sub(): " + test_obj1);

        //Multiplikation
        test_obj1.add(test_obj2);
        System.out.println(test_obj1 + " " + test_obj2);
        test_obj1.mul(test_obj2);
        System.out.println("mul(): " + test_obj1);

        //Division
        test_obj1.div(test_obj2);
        test_obj1.div(test_obj2);
        System.out.println("div(): " + test_obj1);

        //Equality
        test_obj1.mul(test_obj2);
        System.out.println("equal(): " + test_obj1.equals(test_obj2));

        //HashCode
        System.out.println("HashCode(): " + test_obj1.hashCode());
        System.out.println("HashCode(): " + test_obj2.hashCode());
    }
}