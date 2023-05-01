import java.util.Arrays;        //iMPO

public class PolynomialGF2 {
    private final boolean[] polynom;        //das Polynom selbst
    final static boolean[] ZERO = null;        //leeres Polynom (ist Objektunabhängig)
    final static boolean[] ONE = {true};        //1- Polynom (objektunabhängig)


//Hier steht der default-Konstruktor --> setzt das Polynom einfach auf Einspolynom gleich
    public PolynomialGF2() {        
        this.polynom = ONE;
    }

    public PolynomialGF2(boolean[] coefficients) {  //Paramterisierter Konstruktor 
       coefficients = trim(coefficients);       //ruft trim auf, um die Länge anzupassen
       if (coefficients == null)  {
            this.polynom = null;
            return;
       }

        this.polynom = new boolean[coefficients.length];
       for (int i = 0; i < coefficients.length; i++)
            this.polynom[i] = coefficients[i];
    }



    //Ab hier geht es mit den Methoden los

    public boolean[] toArray() {
        return Arrays.copyOf(this.polynom, polynom.length);      //erstell und liefert die Kopie (ist kein getter)
    }

    private static boolean[] trim(boolean[] coefficients) {
        if (coefficients == null)
            return null;

        int length_of_polynom;

        for (length_of_polynom = 0; length_of_polynom < coefficients.length; length_of_polynom++) {
            if (coefficients[length_of_polynom])
                break;
        }

        if (length_of_polynom == coefficients.length-1 && !coefficients[length_of_polynom])
            return null;
        
        boolean[] newcoefficients = new boolean[coefficients.length - length_of_polynom];
        for (int i = 0; i < coefficients.length - length_of_polynom; i++) {
            newcoefficients[i] = coefficients[i+length_of_polynom];
        }

        return newcoefficients;
    }
    
    public boolean isZero() {
        return polynom == null;
    }

    public boolean isOne() {
        return polynom.length == 1;
    }

    public String toString() {
        if (isZero())
            return "";

        String pol = "";
        for (int i = 0; i < polynom.length; i++) {
            if (this.polynom[i]) {
                if (pol.length() > 0)
                    pol += " + ";
                
                if (this.polynom.length-i-1 > 1)
                    pol += "" + "x^" + (polynom.length-1-i);

                else if (this.polynom.length-i-1 == 1)
                    pol += "x";
                
                else
                    pol += "1";
            }
        }

        return pol;
    }

    public boolean equals(PolynomialGF2 object) {
        if (object.polynom.length != this.polynom.length)
            return false;
        
        for (int i = 0; i < polynom.length; i++) {
            if (polynom[i] != object.polynom[i])
                return false;
        }

        return false;
    }

    public PolynomialGF2 clone() {
        PolynomialGF2 newobject = new PolynomialGF2(polynom);
        return newobject;
    }

    public int hashCode() {
        int hash_Code = 0;
        for (int i = 0; i < polynom.length; i++) {
            if (polynom[polynom.length-1-i])
                hash_Code += powerOfTwo(i);
        }
        return hash_Code;
    }

    private static int powerOfTwo(int exponent) {
        if (exponent == 0)
            return 1;
        
        if (exponent == 1)
            return 2;

        int result = powerOfTwo(exponent/2);

        if (exponent % 2 > 0) 
            return (result * result * 2);
        
        else
            return (result * result);
        
    }

    public PolynomialGF2 plus(PolynomialGF2 object) {
        if (this.polynom == null)
            return object.clone();

        else if (object.polynom == null)
            return this.clone();

        int newlength = Math.max(object.polynom.length, this.polynom.length);
        boolean[] added = new boolean[newlength];

        if (newlength > this.polynom.length) {
            for (int i = 0; i < newlength - this.polynom.length; i++) {
                added[i] = object.polynom[i];
            }

            for (int i = newlength - this.polynom.length; i < newlength; i++) {
                added[i] = !(object.polynom[i] == this.polynom[i-(newlength-this.polynom.length)]);
            }
        }

        else {
            for (int i = 0; i < newlength - object.polynom.length; i++) {
                added[i] = this.polynom[i];
            }

            for (int i = newlength - object.polynom.length; i < newlength; i++) {
                added[i] = !(this.polynom[i] == object.polynom[i-(newlength-object.polynom.length)]);
            }
        }

        return new PolynomialGF2(added);
    }

   public PolynomialGF2 times(PolynomialGF2 tomultiplicate) {
        boolean[] multiplicatedarray = new boolean[this.polynom.length + tomultiplicate.polynom.length-1];
        for (int i = this.polynom.length-1; i >= 0; i--) {
            for (int j = tomultiplicate.polynom.length-1; j >= 0; j--) {
                multiplicatedarray[i+j] = !(multiplicatedarray[i+j] == (this.polynom[i] && tomultiplicate.polynom[j]));
            }
        }

        return new PolynomialGF2(multiplicatedarray);
   }

   public int degree() {
        if (isZero())
            return Integer.MIN_VALUE;
    
        return this.polynom.length-1;
   }

   public PolynomialGF2 shift (int k) {
        boolean[] newequation = new boolean[this.polynom.length + k];
        for (int i = 0; i < polynom.length; i++) {
            newequation[i] = this.polynom[i];
        }

        return new PolynomialGF2(newequation);
   }

   public PolynomialGF2 mod(PolynomialGF2 divider) {
        if (this.degree() == 0)
            return divider;

        if (divider.degree() > this.degree()) {
            return this.clone();
        }

        PolynomialGF2 rest = this.clone();
        PolynomialGF2 result = new PolynomialGF2(ZERO);

        while (rest.degree() > divider.degree()) {
            boolean[] tmp = new boolean[rest.degree() - divider.degree() + 1];
            tmp[0] = true;
            result = result.plus(new PolynomialGF2(tmp));
            rest = rest.plus(result.times(divider));
        }

        return rest.shift(1);
   }

}