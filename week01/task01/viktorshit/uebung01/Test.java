public class Test {
    public static void main(String[] args) {
        boolean[] array = {true, true, true, true};
        boolean[] array2 = {false, false, true, true};
        PolynomialGF2 object = new PolynomialGF2(array);
        PolynomialGF2 object2 = new PolynomialGF2(array2);
        System.out.println(object.mod(object2));
    }
}