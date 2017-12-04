package sec;
import java.awt.*;

public class screen1 {
	
	  public static void main(String[] args) {
	  JFrame frame = new JFrame(); // Create a window in which to display things
	  frame.setTitle("Software engineering peer evaluation system");
	  frame.setSize(500, 300); 
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setLayout(new GridLayout(4,1));
	  JPanel panel2 = new JPanel();
	  panel2.setLayout(new FlowLayout());
	  JPanel panel3 = new JPanel();
	  panel3.setLayout(new FlowLayout());
	  JLabel head = new JLabel("Welcome to peer evaluation system",JLabel.CENTER);
	  Object[] elements = new Object[] {"2", "3", "4", "5", "6", "7"};
	  JComboBox comboBox = new JComboBox(elements);
	  JLabel memberscount = new JLabel("Number of group members in your team");
	  JCheckBox checkbox = new JCheckBox("Show previously entered scores");
	  checkbox.setAlignmentX(JCheckBox.CENTER);
	  JButton next = new JButton("Next");
	  panel2.add(memberscount);
	  panel2.add(comboBox);
	  panel2.setMaximumSize(panel2.getPreferredSize());
	  panel3.add(checkbox);
	  panel3.add(next);	  
	  panel3.setMaximumSize(panel3.getPreferredSize());
	  frame.add(head);
	  frame.add(Box.createRigidArea(new Dimension(3,0)));
	  frame.add(panel2);
	  frame.add(panel3);
	  frame.setVisible(true);
  	  }

}
