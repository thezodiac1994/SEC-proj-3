import javax.swing.JOptionPane;
import java.util.*;

/**
 * First example of a GUI shown in class.  This is the infamous "Hello World" demonstration.
 *
 * @author Matthew Hertz
 */
public class WelcomeUser {
  /**
   * Perform a almost, kind-of, sorta GUI version of Hello World.
   *
   * @param args Command-line arguments which we will ignore.
   */
  public static void main(String[] args) {
    String str = JOptionPane.showInputDialog("What is your name?");
    // What does str equal if we press the Cancel button?  
    // What about if we press "OK" without entering any text?
    if (str != null) {
      JOptionPane.showMessageDialog(null, "Hello, " + str + "!");
    } else {
      System.out.println("Quitter");
    }
  }
}
