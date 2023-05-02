public class Test {
    private static final boolean[] c1 = {true, false, true, true};
    private static final boolean[] c2 = {true, false, false, false, true, true, false, true, true};
    private static final boolean[] c3 = {true, true};
    private static final PolynomialGF2 polynom2 = new PolynomialGF2(c2); 
    private static final PolynomialGF2 polynom1 = new PolynomialGF2(c1);
    private static final PolynomialGF2 polynom3 = new PolynomialGF2(c3);

    public static void main(String[] args) {
        test2();
    }

    public static void test1() {
        System.out.println("i | hash | x^i");
        System.out.println("--------------");
        for (int i = 0; i < 7; i++) {
            boolean[] coefficients = new boolean[i+1];
            coefficients[0] = true;
            PolynomialGF2 object = new PolynomialGF2(coefficients);
            System.out.println(i + " | " + "    " + object.mod(polynom1).hashCode() + " | " + object.mod(polynom1));
        }
    }

    public static void test2() {
        String[][] hex_table = new String[16][16];
        for (int i = 0; i <= 0xe; i++) {
            for (int j = 0; j <= 0xe; j++) {
                int pot = j + 16 * i;
                PolynomialGF2 multiplicated = new PolynomialGF2();
                for (int k = 0; k < pot; k++) {
                    multiplicated = multiplicated.times(polynom3);
                }
                multiplicated = multiplicated.mod(polynom2);
                int hex_res = 0;
                boolean[] temp_array = multiplicated.toArray();
                for (int k = multiplicated.degree(); k >= 0; k--) {
                    if (temp_array[k]) {
                        hex_res += PolynomialGF2.powerOfTwo(multiplicated.degree() - k);
                    }
                }
                hex_table[i][j] = Integer.toHexString(hex_res);
                System.out.print(hex_table[i][j] + " ");
            }
            System.out.println();
        }
    }
}