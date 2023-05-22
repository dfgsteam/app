package app.exercise.testing;
import app.exercise.adt.*;
import app.exercise.algebra.*;

/**
 * Die BSTreeTester-Klasse enthält die main-Methode zum Testen des BSTree und der zugehörigen Klassen.
 * @author Julius Hunold
 * Georg-August-Universität in Göttingen
 * @version v1.0
 */
public class BSTreeTester {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Bitte geben Sie mehr Zahlen ein!");
            return;
        }
        if (args.length % 2 > 0) {
            System.err.println("Bitte geben Sie eine gerade Anzahl an Zahlen ein!");
            return;
        }


        CompRational rat = new CompRational(Long.valueOf(args[0]), Long.valueOf(args[1]));
        Node<CompRational> node = new Node<CompRational>(rat);
        BSTree<CompRational> tre = new BSTree<CompRational>(node);

        for (int i = 2; i < args.length; i += 2) {
            rat = new CompRational(Long.valueOf(args[i]), Long.valueOf(args[i + 1]));
            tre.add(rat);
        }

        CompRational[] nums = tre.toArray();
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}

