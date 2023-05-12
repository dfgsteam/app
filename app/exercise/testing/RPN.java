package app.exercise.testing;
import java.util.Stack;
import app.exercise.algebra.*;

public class RPN {
        //Hier sind Fehlermelungen deklariert, damit ich sie wiederverwenden kann
        private static final String OPERATIONS_ERROR = "OperationenOverflow!";
        private static final String OPERANDS_ERROR = "OperationenOverflow!";
        private static final String ABSOLUTE_ERROR = "I brauche nur Operanden (integers) und Operatoren (+,x,/,-)!";

    public static void main(String[] args) {
        

        Stack input = new Stack();          //erzeuge einen Stack für die zukünftigen Operanden
        Rational op1;       //zukünftige Operanden
        Rational op2;

        
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "+":       
                    if (input.empty()) {
                        System.err.println("");     //Checke wenn der Stack leer ist und eine Operation vorliegt, dann Fehler
                        return;
                    }
                    op2 = (Rational)input.pop();
                    if (input.empty()) {
                        System.err.println(OPERATIONS_ERROR);     //man braucht 2 Operanden, wenn nach einem Operanden der Stack schon leer ist, dann Fehler
                        return;
                    }
                    op1 = (Rational)input.pop();
                    op1.add(op2);           //berechne Ergebnis
                    input.push(op1);        //pushe das Ergebnis
                    break;
                case "-":
                    if (input.empty()) {
                        System.err.println(OPERATIONS_ERROR);
                        return;
                    }
                    op2 = (Rational)input.pop();
                    if (input.empty()) {
                        System.err.println(OPERATIONS_ERROR);
                        return;
                    }
                    op1 = (Rational)input.pop();
                    op1.sub(op2);
                    input.push(op1);
                    break;
                case "/":
                    if (input.empty()) {
                        System.err.println(OPERATIONS_ERROR);
                        return;
                    }
                    op2 = (Rational)input.pop();
                    if (input.empty()) {
                        System.err.println(OPERATIONS_ERROR);
                        return;
                    }
                    op1 = (Rational)input.pop();
                    op1.div(op2);
                    input.push(op1);
                    break;
                case "x":
                    if (input.empty()) {
                        System.err.println(OPERATIONS_ERROR);
                        return;
                    }
                    op2 = (Rational)input.pop();
                    if (input.empty()) {
                        System.err.println(OPERATIONS_ERROR);
                        return;
                    }
                    op1 = (Rational)input.pop();
                    op1.mul(op2);
                    input.push(op1);
                    break;
                default:
                    try {
                        input.push(new Rational(Integer.valueOf(args[i]), 1));      //Sonst ist das ein Operand und der Operand wird einfach auf den Stack gepusht
                    }
                    catch (NumberFormatException e) {      
                        System.err.println(ABSOLUTE_ERROR);
                        return;
                    }
            }
        }
        op1 = (Rational)input.pop();
        if (!input.empty()) {
            System.err.println(OPERANDS_ERROR);       //Nach allen Berechnung muss auf dem Stack nur ein Ergebnis vorliegen, wenn da noch was vorliegt, dann waren es zu wenige Operationen -> Fehler
            return;
        }
        System.out.println(op1);
    }
}