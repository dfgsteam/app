public class task01_new {
    public static void main(String args[]) {
        boolean[] bool_test = {false, false, true, true};
        boolean[] bool_test2 = {false, false, true, true};
        //boolean[] bool_test2 = null;
        PolynomialGF2 test1 = new PolynomialGF2(bool_test);
        PolynomialGF2 test2 = new PolynomialGF2(bool_test2);
        PolynomialGF2 test3 = test1.plus(test2);
        //PolynomialGF2 test4 = test1.times(test2);
        System.out.println(test1.toString());
        System.out.println(test2.toString());
        System.out.println(test3.toString());
        //System.out.println(test4.toString());
        System.out.println(test3.isZero());
        System.out.println(test1.hashCode());
        System.out.println(test2.hashCode());
        System.out.println(test3.hashCode());
    }
}
