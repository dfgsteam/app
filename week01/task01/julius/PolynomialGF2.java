import java.util.Arrays;

public class PolynomialGF2 {
    // polynom array
    private final boolean[] polynom;

    private final static boolean[] ZERO = null;
    private final static boolean[] ONE = {true};

    // Default Konstruktor
    public PolynomialGF2() {
        this.polynom = ONE;
    }

    
    public PolynomialGF2(boolean[] inp) {
        if (inp == null) {
            this.polynom = ZERO;
            return;
        }
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
        if (this.isZero()) {
            return hash;
        }
        for (int item_in_polynom=0; item_in_polynom<this.polynom.length; item_in_polynom++) {
            if (this.polynom[item_in_polynom])
                hash += ((int) Math.pow(2, (this.polynom.length-item_in_polynom-1)));
        }
        return hash;
    }

    public boolean equals(PolynomialGF2 equals_test_object) {
        if (this.polynom.length != equals_test_object.polynom.length) 
            return false;
        for (int item_in_polynom=0; item_in_polynom<this.polynom.length; item_in_polynom++)
            if (this.polynom[item_in_polynom] != equals_test_object.polynom[item_in_polynom])
                return false;
        return true;
    }

    public String toString() {
        String res = "";
        if (this.isZero()) {
            return res;
        }
        for (int polynom_length=0; polynom_length < this.polynom.length; polynom_length++)
            if (this.polynom[polynom_length]) {
                if (res.length() > 0)
                    res += " + ";
                res += (this.polynom.length-polynom_length-1 == 0) ? "1" : (this.polynom.length-polynom_length-1 == 1) ? "x" : ("x^" + (this.polynom.length-polynom_length-1));
            }
        return res;
    }

    public PolynomialGF2 plus(PolynomialGF2 plus_object) {
        if (this.isZero())
            return plus_object.clone();
        if (plus_object.isZero())
            return this.clone();

        if (this.polynom.length == plus_object.polynom.length) {
            boolean[] new_object = new boolean[this.polynom.length];
            for (int item_in_polynom=0; item_in_polynom<this.polynom.length; item_in_polynom++) {
                new_object[item_in_polynom] = (this.polynom[item_in_polynom] == plus_object.polynom[item_in_polynom]) ? false : true;
            }
            return new PolynomialGF2(new_object);
        } else {
            boolean[] new_object = new boolean[this.polynom.length > plus_object.polynom.length ? this.polynom.length : plus_object.polynom.length];
            if (this.polynom.length > plus_object.polynom.length) {
                int dif = this.polynom.length - plus_object.polynom.length;
                for (int item_in_polynom=0; item_in_polynom<dif; item_in_polynom++)
                    new_object[item_in_polynom] = this.polynom[item_in_polynom];
                for (int item_in_polynom=0; item_in_polynom<plus_object.polynom.length; item_in_polynom++)
                    new_object[dif+item_in_polynom] = (this.polynom[dif+item_in_polynom] == plus_object.polynom[item_in_polynom]) ? false : true;
            }
            else {
                int dif = plus_object.polynom.length - this.polynom.length;
                for (int item_in_polynom=0; item_in_polynom<dif; item_in_polynom++)
                    new_object[item_in_polynom] = plus_object.polynom[item_in_polynom];
                for (int item_in_polynom=0; item_in_polynom<this.polynom.length; item_in_polynom++) 
                    new_object[dif+item_in_polynom] = (this.polynom[item_in_polynom] == plus_object.polynom[dif+item_in_polynom]) ? false : true;
            }
            return new PolynomialGF2(new_object);     
        }
    }

    public PolynomialGF2 times(PolynomialGF2 times_object) {
        if (this.polynom == null || times_object.polynom == null) {
            boolean[] bool_test = {false};
            return new PolynomialGF2(bool_test);
        }
        boolean[] new_object = new boolean[this.polynom.length+times_object.polynom.length-1];
        for (int item_in_this_polynom=0; item_in_this_polynom < this.polynom.length; item_in_this_polynom++) {
            for (int item_in_other_polynom=0; item_in_other_polynom < times_object.polynom.length; item_in_other_polynom++) {
                int pos = (item_in_this_polynom) + (item_in_other_polynom);
                if (this.polynom[item_in_this_polynom] && times_object.polynom[item_in_other_polynom])
                    new_object[pos] = !new_object[pos];
                //System.out.println(Arrays.toString(new_object));
            }
        }
        return new PolynomialGF2(new_object);
    }

    public PolynomialGF2 mod(PolynomialGF2 divider) {
        if (this.degree() < divider.degree()) {
            return this.clone();
        }
    
        int n = this.polynom.length;
        int m = divider.polynom.length;
        boolean[] result = Arrays.copyOf(this.polynom, n);
        
        for (int i = n - m - 1; i >= 0; i--) {
            if (result[i + m]) {
                for (int j = 0; j < m; j++) {
                    int a = result[i + j] ? 1: 0;
                    int b = divider.polynom[j] ? 1 : 0;
                    result[i + j] = (a ^ b) == 1 ? true : false;
                }
            }
        }
        
        return new PolynomialGF2(Arrays.copyOf(result, n - m));
    }

    public int degree() {
        return this.polynom.length-1;
    }

    public PolynomialGF2 shift(int k) {
        boolean[] new_object = new boolean[this.polynom.length + k];
        for (int item_in_this_polynom = 0; item_in_this_polynom < this.polynom.length; item_in_this_polynom++)
            new_object[item_in_this_polynom] = this.polynom[item_in_this_polynom];
        return new PolynomialGF2(new_object);
    }
    
}