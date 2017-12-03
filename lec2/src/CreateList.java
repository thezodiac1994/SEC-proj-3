import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * With this example, we look at the full MVC (model-view-controller) Java GUI system. We have now seen at least a
 * little bit of each of Swing's different areas.
 *
 * @author Matthew Hertz
 */
public class CreateList extends JFrame implements ListSelectionListener, ActionListener {
  /** List of names that I will use. */
  private JList myList;

  /** Create a new window containing our list. */
  public CreateList() {
    // Create the description for our list
    @SuppressWarnings("unchecked")
    JLabel description = new JLabel("Who should be called on next: ");
    add(BorderLayout.NORTH, description);
    myList = new JList();
    ListModel model = new ListModel9();
    myList.setModel(model);
    myList.setVisibleRowCount(1);
    myList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    myList.addListSelectionListener(this);
    add(BorderLayout.CENTER, myList);
    JList myList2 = new JList();
    myList2.setModel(model);
    myList2.setVisibleRowCount(1);
    myList2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    add(BorderLayout.EAST, myList2);

    // Finally, create the button component.
    JButton button = new JButton("Add a student");
    button.addActionListener(this);
    add(BorderLayout.SOUTH, button);
  }

  /**
   * Run the example program that uses the full MVC scheme.
   *
   * @param args Command-line arguments which we will ignore.
   */
  public static void main(String[] args) {
    CreateList window = new CreateList();

    // Finish setting up this window.
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setTitle("Full Example");
    window.setSize(300, 300);
    window.setVisible(true);
  }

  /*
   * (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  public void actionPerformed(ActionEvent arg0) {
    // You selected the button, lets ask a question and go from there!
    String value = JOptionPane.showInputDialog(null, "Student to be added:");
    if (value != null) {
      ((ListModel9)myList.getModel()).addData(value);
    }      
  }

  /*
   * (non-Javadoc)
   * @see javax.swing.event.ListSelectionListener#valueChanged(javax.swing.event.ListSelectionEvent)
   */
  public void valueChanged(ListSelectionEvent arg0) {
      // Get the selected value
      String selection = ((String)myList.getSelectedValue());
      // Ask them what they think
      JOptionPane.showMessageDialog(null, selection + ", what do you think?");
  }
}