import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * This example shows how we can use some of the built-in dialog boxes.
 *
 * @author Matthew Hertz
 */
public class DialogBox2 extends JFrame implements ActionListener {
  /** Item used to access help. */
  private JMenuItem openItem;

  /** Item used to exit this program. */
  private JMenuItem exitItem;

  /** Our little message bar. */
  private JLabel label;

  /** Create an instance of the class: a window containing a menu. */
  public DialogBox2() {
    // Create the menu bar and set it on the window.
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);

    // Create the File menu and add it to the menu bar.
    JMenu fileMenu = new JMenu();
    fileMenu.setText("File"); // What the item reads
    fileMenu.setMnemonic(KeyEvent.VK_F); // Shortcut for this menu
    menuBar.add(fileMenu);

    // Create the open item and add it to the file menu.
    openItem = new JMenuItem();
    fileMenu.add(openItem);
    openItem.setText("Open");
    openItem.addActionListener(this);
    openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, Event.CTRL_MASK));

    // Create the exit item and add it to the File menu
    exitItem = new JMenuItem("Exit");
    fileMenu.add(exitItem);
    exitItem.setMnemonic(KeyEvent.VK_X); // Use the "X" key to select.
    exitItem.addActionListener(this); // Use the Example7 class to handle these events.
    exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, Event.ALT_MASK));

    // Create and display the label.
    label = new JLabel("You ain't seen nothin' yet.");
    add(label);
  }

  /**
   * Run the example program that uses a menu.
   *
   * @param args Command-line arguments which we will ignore.
   */
  public static void main(String[] args) {
    Example8b window = new Example8b();

    // Finish setting up this window.
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setTitle("Dialog Example");
    window.setSize(300, 300);
    window.setVisible(true);
  }

  /*
   * (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  public void actionPerformed(ActionEvent arg0) {
    if (arg0.getSource() == exitItem) {
      dispose();
    } else if (arg0.getSource() == openItem) {
      // Create our dialog that allows us to choose a file
      JFileChooser opener = new JFileChooser();
      // Allow the choose to include a *.* filter
      opener.setAcceptAllFileFilterUsed(true);
      // Show the opening result.
      int result = opener.showOpenDialog(null);
      // Handle the different options that can occur.
      if (result == JFileChooser.APPROVE_OPTION) {
        label.setText("You selected: " + opener.getSelectedFile());
      } else if (result == JFileChooser.CANCEL_OPTION) {
        label.setText("You canceled selecting: " + opener.getSelectedFile());
      } else if (result == JFileChooser.ERROR_OPTION) {
        label.setText("Something bad happened");
      }
    }
  }
}