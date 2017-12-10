import java.awt.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


public class screen1 implements ActionListener{
	
	static JFrame frame =  new JFrame(); // This is the frame that will be used for the display 
	static JPanel panel2 = new JPanel(); // this is one of the panels that will be on the frames 
	static JPanel panel3 = new JPanel(); // this is another panel that will be on the frames
	static JCheckBox checkbox = new JCheckBox("Show previously entered scores"); // checkbox for previously entered or not 
	static String[] elements = new String[] {"2", "3", "4", "5", "6", "7"}; // the number of members can be from 2 to 7 in the dropdown
	static JComboBox<String> comboBox = new JComboBox<String>(elements); // the dropdown that will give a choice between 2 to 7 members 
	  		  
		 

	public void initialize_frame (JFrame frame1){
		/**
		* this function initializes all the properties of the original frame 
		@param frame1 : it initializes the frame that we will be using right at the beginning of the GUI i.e it is the first screen 
		*/
		frame1.setTitle("Software engineering peer evaluation system");  // title of the frame
	  	frame1.setSize(500, 300);   // size of frame
	  	frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	  	frame1.setLayout(new GridLayout(4,1)); // set the layout of the original frame to 4 x 1 grid 
	  	JLabel head = new JLabel("Welcome to peer evaluation system",JLabel.CENTER);  // header of the frame 
	  	frame1.add(Box.createRigidArea(new Dimension(3,0)));
	  	frame1.add(head); // add header to the frame 
	  	
	}

	public void set_panel2(JPanel panel){
		/**
	   	* this function sets all the properties of the panel2 -> it holds a combobox dropdown for the number of members in the group
		@param panel: It is the panel that needs to be set -> (panel2 here is passed as parameter from the main function) 
		*/
		panel.setLayout(new FlowLayout());
	  	JLabel memberscount = new JLabel("Number of group members in your team"); // message to input the number of members in the group 
	  	panel.add(memberscount); // add label to the panel
	  	panel.add(comboBox); // add the dropdown
	  	panel.setMaximumSize(panel.getPreferredSize());

	}

	public void set_panel3(JPanel panel){
	  
	 	 /**
	 *  this function sets all the properties of the panel3 -> its a check box for whether score has been previously filled or not along  with a NEXT button
		@param panel: It is the panel that needs to be set -> (panel3 here is passed as parameter from the main function) 
		*/

		 panel.setLayout(new FlowLayout());  
		 checkbox.setAlignmentX(JCheckBox.CENTER); // center align
		 panel.add(checkbox); // add the check box 
		 JButton next = new JButton("Next"); // the bext button 
		 next.addActionListener(this);  // action listener to control what should be done on the click of next button 
		 panel.add(next);	 // add button to the panel
		 panel.setMaximumSize(panel.getPreferredSize());
	  
//	  screen2 (3,true);
	}

	public void actionPerformed(ActionEvent arg0) {


	/**
	 * This method is called when the next button is clicked. It creates a screen2 object and goes to screen2
	*/

		//System.out.println(membersCount + " " + flag);
		this.frame.setVisible(false); // we need to close this frame 

		String s = comboBox.getSelectedItem().toString(); // retrieve the choice selected from the dropdown
		int x = Integer.parseInt(s); // convert string to int
		boolean flag = checkbox.isSelected(); // flag is true if checkbox is selected
		screen2 obj = new screen2(x,flag); // pass number of people in group, whether member scores were filled earlier
	  	obj.createAndShowGUI(); // this is the function in screen2 that does all thw work
		

	}


	public static void main(String[] args) {

	/**
	 * This is the main method which is responsible of creating screen1 GUI
	*/

	  	 screen1 objs1 = new screen1(); // create instance of screen1 
		 objs1.initialize_frame(objs1.frame); // initialize the frame 
		 objs1.set_panel2(objs1.panel2); // set 1st panel
		 objs1.set_panel3(objs1.panel3); // set 2nd panel
		 objs1.frame.add(panel2); // add panel to frame 
		 objs1.frame.add(panel3);
	  	 objs1.frame.setVisible(true); // display the frame


	  }

}
