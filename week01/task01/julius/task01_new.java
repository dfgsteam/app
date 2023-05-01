package julius;
import java.util.Arrays;

class PolynomialGF2 {
    // polynom array
    private final boolean[] polynom;

    private final static boolean[] ZERO = null;
    private final static boolean[] ONE = {true};

    // Default Konstruktor
    public PolynomialGF2() {
        this.polynom = ONE;
    }

    public PolynomialGF2(boolean[] inp) {
        boolean[] inp_trim = trim(inp);
        this.polynom = inp_trim;
    }

    private boolean[] trim(boolean[] polynom) {
        for (int item=0; item<polynom.length; item++) {
            if (polynom[item]) {
                if (item == 0)
                    return polynom;
                boolean[] polynom_temp = new boolean[polynom.length-item];
                int counter = 0;
                for (int item2=item; item2<polynom.length; item2++) {
                    polynom_temp[counter] = polynom[item2];
                    counter++;
                }
                return polynom_temp;
            } 
        }
        return null;
        
    }

    public boolean[] toArray() {
        return Arrays.copyOf(this.polynom, this.polynom.length);
    }

    public boolean isZero() {
        return this.polynom == null;     
    }

    public boolean isOne () {
        return this.polynom.length == 1;    
    }

    public PolynomialGF2 clone() {
        PolynomialGF2 new_object = new PolynomialGF2(this.polynom);
        return new_object;
    }

    public int hashCode() {
        int hash = 0;
        for (int item_in_polynom=0; item_in_polynom<this.polynom.length; item_in_polynom++) {
            hash += (item_in_polynom*((int) Math.pow(2, item_in_polynom)));
        }
        return hash;
    }

    public boolean equals(PolynomialGF2 equals_test_obejct) {
        if (this.polynom.length != equals_test_obejct.polynom.length) 
            return false;
        for (int item_in_polynom=0; item_in_polynom<this.polynom.length; item_in_polynom++)
            if (this.polynom[item_in_polynom] != equals_test_obejct.polynom[item_in_polynom])
                return false;
        return true;
    }

    public String toString() {
        String res = "";
        for (int polynom_length=0; polynom_length < this.polynom.length; polynom_length++)
            if (this.polynom[polynom_length]) {
                if (res.length() > 0)
                    res += " + ";
                res += "x^" + (this.polynom.length-polynom_length);
            }
        return res;
    }

    public PolynomialGF2 plus(PolynomialGF2 plus_obejct) {
        if (this.polynom.length == plus_obejct.polynom.length) {
            boolean[] new_object = new boolean[this.polynom.length];
            for (int item_in_polynom=0; item_in_polynom<this.polynom.length; item_in_polynom++) {
                new_object[item_in_polynom] = (this.polynom[item_in_polynom] == plus_obejct.polynom[item_in_polynom]) ? false : true;
            }
            return new PolynomialGF2(new_object);
        } else {
            boolean[] new_object = new boolean[this.polynom.length > plus_obejct.polynom.length ? this.polynom.length : plus_obejct.polynom.length];
            if (this.polynom.length > plus_obejct.polynom.length) {
                int dif = this.polynom.length - plus_obejct.polynom.length;
                for (int item_in_polynom=0; item_in_polynom<dif; item_in_polynom++) {
                    new_object[item_in_polynom] = this.polynom[item_in_polynom];
                }
                for (int item_in_polynom=0; item_in_polynom<plus_obejct.polynom.length; item_in_polynom++) {
                    new_object[dif+item_in_polynom] = (this.polynom[dif+item_in_polynom] == plus_obejct.polynom[item_in_polynom]) ? false : true;
                }
            }
            else {
                int dif = plus_obejct.polynom.length - this.polynom.length;
                for (int item_in_polynom=0; item_in_polynom<dif; item_in_polynom++) {
                    new_object[item_in_polynom] = plus_obejct.polynom[item_in_polynom];
                }
                for (int item_in_polynom=0; item_in_polynom<this.polynom.length; item_in_polynom++) {
                    new_object[dif+item_in_polynom] = (this.polynom[item_in_polynom] == plus_obejct.polynom[dif+item_in_polynom]) ? false : true;
                }
            }
            return new PolynomialGF2(new_object);     
        }
    }




}

public class task01_new {
    public static void main(String args[]) {

        System.out.println("test");
    }
}
