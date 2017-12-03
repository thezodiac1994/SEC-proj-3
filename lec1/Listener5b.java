import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * This class does not create a JFrame (or anything else)
 * but simply listens for action events. 
 * 
 * @author Matthew Hertz
 */
public class Listener5b implements ActionListener {
  /** Counts the number of times the action has been performed. */
  private int clicks;
  
  /** Create a new instance of this class that has not yet recorded a click. */
  public Listener5b() {
    clicks = 0;
  }
  
  /**
   * When an event occurs, update the buttons text to reflect this fact.
   */
  public void actionPerformed(ActionEvent arg0) {
    // Increase the number of times this button has been clicked.
    clicks += 1;
    // Get the button that was clicked.
    JButton btn = (JButton)arg0.getSource();
    // Update the text to reflect this fact.
    btn.setText("I've been clicked " + clicks + " times");
  }
}
