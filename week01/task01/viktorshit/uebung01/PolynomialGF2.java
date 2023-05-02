import java.util.Arrays;        //importiere java.util.Arrays

public class PolynomialGF2 {
//-------------------------------------------------------------------------------------------------------
//Hier sind die Insanzvaraibeln
    private final boolean[] polynom;        //das Polynom selbst
    final static boolean[] ZERO = null;        //leeres Polynom (ist Objektunabhängig,deswegen static)
    final static boolean[] ONE = {true};        //1- Polynom (objektunabhängig, deswegen static)

//-------------------------------------------------------------------------------------------------------
//Hier steht der default-Konstruktor --> setzt das Polynom einfach auf Einspolynom gleich
    public PolynomialGF2() {        
        this.polynom = Arrays.copyOf(ONE, ONE.length);
    }

//Paramteisierter Konstruktor
    public PolynomialGF2(boolean[] coefficients) {  //Paramterisierter Konstruktor 
       coefficients = trim(coefficients);       //ruft trim auf, um die Länge anzupassen (lässt unnötige Koeffizienten weg)
       if (coefficients == null)  {		
            this.polynom = null;
            return;
       }

        this.polynom = new boolean[coefficients.length];
       for (int i = 0; i < coefficients.length; i++)
            this.polynom[i] = coefficients[i];
    }


//-------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------
    //Ab hier geht es mit den Methoden los
    
				
    public boolean[] toArray() {		
        return Arrays.copyOf(this.polynom, polynom.length);      //erstellt und liefert die Kopie (ist kein getter)
    }


    private static boolean[] trim(boolean[] coefficients) {	//Der Trimer
        if (coefficients == null)	//Falls Referenz auf null,liefere null
            return null;

        int length_of_polynom;		//Länge des zukünftigen Polynoms

        for (length_of_polynom = 0; length_of_polynom < coefficients.length; length_of_polynom++)
            if (coefficients[length_of_polynom])	//es geht darum herauszufinden, ab welcher Stelle der erste Koeffizient = 1 ist
                break;
        

        if (length_of_polynom == coefficients.length-1 && !coefficients[length_of_polynom])	//Es kann sein, dass alle Koeffizienten = 0 sind, außer den letzten
            return null;
        
        boolean[] newcoefficients = new boolean[coefficients.length - length_of_polynom];	//Erstelle neuen bOOLEAn Array für neue Koeffizienten
        for (int i = 0; i < coefficients.length - length_of_polynom; i++)		//packe alles ab dem ersten nicht false Eintrag da rein
            newcoefficients[i] = coefficients[i+length_of_polynom];

        return newcoefficients;
    }
    
    
    
    public boolean isZero() {	//prüfe ob ZERO
        return this.polynom == null;
    }
    
    

    public boolean isOne() {		//ich brauche mir keinen Kopf darüber zu machen, dass this.polynom[0] = 1, denn tim ist da
        return this.polynom.length == 1;
    }
    
    

    public String toString() {		//überschriebene toString Methode
        if (isZero())
            return "";			//falls es sich um ein 0 POlynom handelt, wird ein String mit dem Leeren Zeichen zurückgeliefert

        String pol = "";		//sonst initiaoilisere zukünftige string-variable
        for (int i = 0; i < this.polynom.length; i++) {
            if (this.polynom[i]) {
                if (pol.length() > 0)
                    pol += " + ";		//"+"
                
                if (this.polynom.length-i-1 > 1)
                    pol += "" + "x^" + (this.polynom.length-1-i); //x und die POtenz

                else if (this.polynom.length-i-1 == 1)		//Case für x^1
                    pol += "x";	
                
                else
                    pol += "1";					//Case für x^0
            }
        }

        return pol;
    }
    
    

    public boolean equals(PolynomialGF2 object) {		//einfacher sequentieller Vergleich zweier boolean Arrays
        if (object.polynom.length != this.polynom.length)
            return false;
        
        for (int i = 0; i < this.polynom.length; i++) {
            if (polynom[i] != object.polynom[i])
                return false;
        }

        return false;
    }
    
    

    public PolynomialGF2 clone() {			//Überschreibung der Clone Methode
        return new PolynomialGF2(polynom);
    }
    
    

    public int hashCode() {
        int hash_Code = 0;
        for (int i = 0; i < polynom.length; i++) {
            if (polynom[polynom.length-1-i])
                hash_Code += powerOfTwo(i);	//Summe der 2^i Potenzen
        }
        return hash_Code;
    }
    
    

    public static int powerOfTwo(int exponent) {	//das ist bloß meine Funktion zur effizienten Berechnung von 2^n für den HashCode, die ich nur kurz brauche
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
	//Falls eins der Polynome 0 ist, liefere den anderen
        else if (object.polynom == null)
            return this.clone();
            
        int newlength = Math.max(object.polynom.length, this.polynom.length);	//bestimmte die neue Länge des Polynoms und das ist immer die höchste POtenz+1 der Summanden
        boolean[] added = new boolean[newlength];

        if (newlength > this.polynom.length) {
            for (int i = 0; i < newlength - this.polynom.length; i++) {
                added[i] = object.polynom[i];
            }
		//Falls das 2te Polynom größer ist, kann ich ja einfach die überschreitenden Einträge übernehmen
            for (int i = newlength - this.polynom.length; i < newlength; i++) {
                added[i] = !(object.polynom[i] == this.polynom[i-(newlength-this.polynom.length)]); //die Defintion des NXOR Operators ist passend für die Adiition
            }
        }

        else {
            for (int i = 0; i < newlength - object.polynom.length; i++) {
                added[i] = this.polynom[i];
            }
		//Sonst mache genau das gleiche bloß mit vertauschten POlynomen
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
                multiplicatedarray[i+j] = !(multiplicatedarray[i+j] == (this.polynom[i] && tomultiplicate.polynom[j]));	//nicht-äquivalent ist passend für 
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
            return this.clone();

        if (divider.degree() > this.degree()) {
            return this.clone();
        }

        PolynomialGF2 rest = this.clone();
        PolynomialGF2 result = new PolynomialGF2(ZERO);

        while (rest.degree() >= divider.degree()) {
            boolean[] tmp = new boolean[rest.degree() - divider.degree() + 1];
            tmp[0] = true;
            result = result.plus(new PolynomialGF2(tmp));
            rest = rest.plus(result.times(divider));
        }

        return rest;
   }

}
