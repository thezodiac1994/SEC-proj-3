import java.awt.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


public class screen1 implements ActionListener{
	
	static JFrame frame =  new JFrame();
	static JPanel panel2 = new JPanel();
	static JPanel panel3 = new JPanel();
	static JCheckBox checkbox = new JCheckBox("Show previously entered scores");
	static String[] elements = new String[] {"2", "3", "4", "5", "6", "7"};
	static JComboBox<String> comboBox = new JComboBox<String>(elements);
	  		  
		 

	public void initialize_frame (JFrame frame1){
		
		frame1.setTitle("Software engineering peer evaluation system");  
	  	frame1.setSize(500, 300);  
	  	frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	  	frame1.setLayout(new GridLayout(4,1));
	  	JLabel head = new JLabel("Welcome to peer evaluation system",JLabel.CENTER);
	  	frame1.add(Box.createRigidArea(new Dimension(3,0)));
	  	frame1.add(head);
	  	
	}

	public void set_panel2(JPanel panel){
		panel.setLayout(new FlowLayout());
	  	JLabel memberscount = new JLabel("Number of group members in your team");
	  	panel.add(memberscount);
	  	panel.add(comboBox);
	  	panel.setMaximumSize(panel.getPreferredSize());

	}

	public void set_panel3(JPanel panel){
	  panel.setLayout(new FlowLayout());
	  checkbox.setAlignmentX(JCheckBox.CENTER);
	  panel.add(checkbox);
	  JButton next = new JButton("Next");
	  next.addActionListener(this);
	  panel.add(next);	  
	  panel.setMaximumSize(panel.getPreferredSize());
	  
//	  screen2 (3,true);
	}

	public void actionPerformed(ActionEvent arg0) {
		//System.out.println(membersCount + " " + flag);
		this.frame.setVisible(false);

		String s = comboBox.getSelectedItem().toString();
		int x = Integer.parseInt(s);
		boolean flag = checkbox.isSelected();
		screen2 obj = new screen2(x,flag);
	  	obj.createAndShowGUI();
		

	}


	public static void main(String[] args) {
	  	 screen1 objs1 = new screen1();
		 objs1.initialize_frame(objs1.frame); 
		 objs1.set_panel2(objs1.panel2);
		 objs1.set_panel3(objs1.panel3);
		 objs1.frame.add(panel2);
		 objs1.frame.add(panel3);
	  	 objs1.frame.setVisible(true);


	  }

}
