/**
 * Die Klasse Uebung04 enthält die main-Methode und dient als Einstiegspunkt für das Programm.
 * Sie liest den Dateinamen für das Bild als Argument aus der Kommandozeile und startet die Anwendung.
 * @author Julius Hunold
 * Georg-August-Universität in Göttingen
 * @version v1.0
 */
public class Uebung04 {
    /**
     * Die main-Methode ist der Einstiegspunkt für das Programm.
     * Sie liest den Dateinamen für das Bild als Argument aus der Kommandozeile und startet die Anwendung.
     *
     * @param args    die Kommandozeilenargumente
     */
    public static void main( String[] args ) { 
        if (args.length != 1) {
            System.out.println("Du hast kein eindeutiges Bild genannt.");
            return;
        }
        new AppDrawEvent(args[0]);
    } 
}
