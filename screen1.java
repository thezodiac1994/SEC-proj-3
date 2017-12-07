import java.awt.*;
import javax.swing.*;


public class screen1 {
	
	  
	public static void initialize_frame (JFrame frame){
		
		frame.setTitle("Software engineering peer evaluation system");  
	  	frame.setSize(500, 300);  
	  	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	  	frame.setLayout(new GridLayout(4,1));
	  	JLabel head = new JLabel("Welcome to peer evaluation system",JLabel.CENTER);
	  	frame.add(Box.createRigidArea(new Dimension(3,0)));
	  	frame.add(head);
	  	
	}

	public static void set_panel2(JPanel panel2){
		panel2.setLayout(new FlowLayout());
	  	JLabel memberscount = new JLabel("Number of group members in your team");
	  	panel2.add(memberscount);
	  	Object[] elements = new Object[] {"2", "3", "4", "5", "6", "7"};
	  	JComboBox comboBox = new JComboBox(elements);
	  	panel2.add(comboBox);
	  	panel2.setMaximumSize(panel2.getPreferredSize());
	  
	}

	public static void set_panel3(JPanel panel3){
	  panel3.setLayout(new FlowLayout());
	  JCheckBox checkbox = new JCheckBox("Show previously entered scores");
	  checkbox.setAlignmentX(JCheckBox.CENTER);
	  panel3.add(checkbox);
	  JButton next = new JButton("Next");
	  panel3.add(next);	  
	  panel3.setMaximumSize(panel3.getPreferredSize());
	  	
	}


	public static void main(String[] args) {
	  
		JFrame frame =  new JFrame();
		 initialize_frame(frame); 
		  
			  
		 JPanel panel2 = new JPanel();
		 set_panel2(panel2);


		 JPanel panel3 = new JPanel();
		 set_panel3(panel3);
		  

		 frame.add(panel2);
		 frame.add(panel3);
	  	 frame.setVisible(true);
  	  }

}
