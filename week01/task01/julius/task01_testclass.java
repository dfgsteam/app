public class task01_testclass {
    public static void main(String[] args) {        //testklasse
        int test_caseses_num = 7;
        boolean[] mod_testclass_array = {true, false, true, true};
        PolynomialGF2 mod_testclass = new PolynomialGF2(mod_testclass_array);

        System.out.println("i\t| hash \t| x^i");
        System.out.println("--------|-------|------");

        for (int test_case_id=0; test_case_id<test_caseses_num; test_case_id++) {
            boolean[] test_case_bool = new boolean[test_case_id+1];
            test_case_bool[0] = true;
            PolynomialGF2 test_case_object = new PolynomialGF2(test_case_bool);
            System.out.println(test_case_id + "\t| " + test_case_object.mod(mod_testclass).hashCode() + "\t| " + test_case_object.mod(mod_testclass).toString());

        }

        System.out.println("Test 2:");
        
    }
}
