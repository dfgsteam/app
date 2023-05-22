import javax.swing.*; 


/**
 * Die Klasse AppFrame erweitert die Klasse JFrame und repräsentiert ein Fenster für die Anwendung.
 * Das Fenster besitzt einen Titel und wird beim Schließen der Anwendung automatisch geschlossen.
 * @author Julius Hunold
 * Georg-August-Universität in Göttingen
 * @version v1.0
 */
class AppFrame extends JFrame { 
  /**
   * Erzeugt ein neues AppFrame-Objekt mit dem angegebenen Titel.
   *
   * @param title    der Titel des Fensters
   */
  public AppFrame(String title) {
      super(title);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  } 
}