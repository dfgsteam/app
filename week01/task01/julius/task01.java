package julius;
public class PolynomialGF2 {
    
    private boolean[] koeffizienten; // Koeffizienten-Feld
    private int grad; // Grad des Polynoms
    
    public static final PolynomialGF2 ZERO = new PolynomialGF2(new boolean[] {}); // Null-Polynom
    public static final PolynomialGF2 ONE = new PolynomialGF2(new boolean[] { true }); // Eins-Polynom
    


    // Konstruktor, der das Eins-Polynom erzeugt
    public PolynomialGF2() {
        this(new boolean[] { true });
    }
    
    // Konstruktor, der ein Koeffizienten-Feld  ̈ubergeben bekommt und ein dazu passendes Polynom erzeugt
    public PolynomialGF2(boolean[] koeffizienten) {
        this.koeffizienten = Arrays.copyOf(koeffizienten, koeffizienten.length);
        this.koeffizienten = trim(this.koeffizienten); 
        this.grad = this.koeffizienten.length - 1;
    }
    
    // Entfernt alle false werte bis zum ersten true -> dann hört es auf
    private boolean[] trim(boolean[] koeffizienten) { 
        int i = koeffizienten.length - 1;
        while (i >= 0 && !koeffizienten[i]) {
            i--;
        }
        return Arrays.copyOf(koeffizienten, i + 1);
    }


    // Überprüft, ob Polynom Nullpolynom ist
    public boolean isZero() {
        return this.equals(ZERO.koeffizienten);
    }

    // Überprüft, ob Polynom Einspolynom ist
    public boolean isOne() {
        return this.equals(ONE.koeffizienten);
    }

    // Gibt Kopie des Polynoms aus
    public boolean[] toArray() {
        return Arrays.copyOf(koeffizienten, koeffizienten.length);
    }

    public int grad() {
        return grad;
    }

    public int grad() {
        return grad;
    }

    public PolynomialGF2 shift(int k) {
        if (k < 0) {
            throw new IllegalArgumentException("shift amount must be non-negative");
        }
        boolean[] shiftedkoeffizienten = new boolean[koeffizienten.length + k];
        System.arraycopy(koeffizienten, 0, shiftedkoeffizienten, k, koeffizienten.length);
        return new PolynomialGF2(shiftedkoeffizienten);
    }



    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PolynomialGF2)) {
            return false;
        }
        PolynomialGF2 other = (PolynomialGF2) obj;
        return Arrays.equals(koeffizienten, other.koeffizienten);
    }

    public int hashCode() {
        int result = 1;
        for (int i = 0; i < koeffizienten.length; i++) {
            result = 31 * result + (koeffizienten[i] ? 1 : 0); // Wenn Koeffizient true ist = 1, sonst 0
        }
        return result;
    }

    public String toString() {
        if (isZero()) {
            return "0";
        }
        StringBuilder string_builder = new StringBuilder();
        boolean isFirst = true;
        for (int i = koeffizienten.length - 1; i >= 0; i--) {
            if (koeffizienten[i]) {
                if (isFirst) {
                    isFirst = false;
                } else {
                    string_builder.append(" + ");
                }
                if (i == 0) {
                    string_builder.append("1");
                } else if (i == 1) {
                    string_builder.append("x");
                } else {
                    string_builder.append("x^").append(i);
                }
            }
        }
        return string_builder.toString();

        public PolynomialGF2 plus(PolynomialGF2 other) {
            // Determine the length of the result
            int maxLength = Math.max(this.koeffizienten.length, other.koeffizienten.length);
            boolean[] ergkoeffizienten = new boolean[maxLength];
        
            // Add the koeffizienten of both polynomials
            for (int i = 0; i < maxLength; i++) {
                boolean a = i < this.koeffizienten.length ? this.koeffizienten[i] : false;
                boolean b = i < other.koeffizienten.length ? other.koeffizienten[i] : false;
                ergkoeffizienten[i] = a ^ b;
            }
        
            // Create the resulting polynomial
            return new PolynomialGF2(ergkoeffizienten);
        }
        
        public PolynomialGF2 times(PolynomialGF2 other) {
            // Determine the length of the result
            int resultLength = this.koeffizienten.length + other.koeffizienten.length - 1;
            boolean[] ergkoeffizienten = new boolean[resultLength];
        
            // Multiply the koeffizienten of both polynomials
            for (int i = 0; i < this.koeffizienten.length; i++) {
                for (int j = 0; j < other.koeffizienten.length; j++) {
                    ergkoeffizienten[i + j] ^= this.koeffizienten[i] & other.koeffizienten[j];
                }
            }
        
            // Create the resulting polynomial
            return new PolynomialGF2(ergkoeffizienten);
        }
        
        public PolynomialGF2 mod(PolynomialGF2 divisor) {
            // Check if divisor is zero
            if (divisor.isZero()) {
                throw new ArithmeticException("Division by zero");
            }
        
            PolynomialGF2 remainder = new PolynomialGF2(this.koeffizienten);
            while (remainder.grad() >= divisor.grad()) {
                // Shift the divisor to match the grad of the remainder
                int shiftAmount = remainder.grad() - divisor.grad();
                PolynomialGF2 shiftedDivisor = divisor.shift(shiftAmount);
        
                // XOR the shifted divisor with the remainder
                remainder = remainder.plus(shiftedDivisor);
            }
        
            // The remainder is the result
            return remainder;
        }
    }

    public PolynomialGF2 clone() {
        try {
            PolynomialGF2 clone = (PolynomialGF2) super.clone();
            clone.koeffizienten = koeffizienten.clone();
            return clone;
        } catch (CloneNotSupportedException e) { // Fehler, wenn der Clone nicht funktioniert hat
            throw new AssertionError(); // gibt Fehler "AssertionError" aus
        }
    }
}













}


public class task01 {
    public static void main(String args[]) {
        System.out.println("test");
    }
}