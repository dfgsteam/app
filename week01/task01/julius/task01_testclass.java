public class task01_testclass {
    public static void main(String[] args) {        //testklasse
        int test_caseses_num = 7;
        boolean[] mod_testclass_array = {true, false, true, true};
        PolynomialGF2 mod_testclass = new PolynomialGF2(mod_testclass_array);

        System.out.println("Test 2:\n");
        System.out.println("i\t| hash \t| x^i");
        System.out.println("--------|-------|------");

        for (int test_case_id=0; test_case_id<test_caseses_num; test_case_id++) {
            boolean[] test_case_bool = new boolean[test_case_id+1];
            test_case_bool[0] = true;
            PolynomialGF2 test_case_object = new PolynomialGF2(test_case_bool);
            System.out.println(test_case_id + "\t| " + test_case_object.mod(mod_testclass).hashCode() + "\t| " + test_case_object.mod(mod_testclass).toString());

        }

        System.out.println("\n\nTest 2:\n");
        for (int column=-1; column<16; column++) {
            if (column==-1) {
                String header1 = "";
                String header2 = "";
                for (int row=-1; row<16; row++) {
                    if (row==-1) {
                        header1 += "  |  ";
                        header2 += "---";
                    } else {
                        header1 += (Integer.toHexString(row) + "   ");
                        header2 += "----";
                    }
                }
                System.out.println(header1);
                System.out.println(header2);
                
            } else {
                String line = "";
                line += Integer.toHexString(column);
                line += " | ";
                for (int column_row=0; column_row<16; column_row++) {
                    line += Integer.toHexString(column_row).length() < 2 ? "0" + Integer.toHexString(column_row) : Integer.toHexString(column_row);
                    line += "  ";
                }
                System.out.println(line);

            }
        }
    }
}
