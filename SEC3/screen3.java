import java.awt.GridLayout;

import javax.swing.*;

/**
 * Displays the normalized scores of all the team members
 * @author Group 11
 *
 */
public class screen3 {
	JFrame frame;
	JPanel panel;
	JPanel panel0;
	JPanel panel1;
	JPanel panel2;

    JLabel[] memlabels=new JLabel[7];
    JLabel[] scorelabels=new JLabel[7];


	public screen3(){
		
	}
	
	/**
	 * Display screen constructor called from previous window
	 * @param members   //Team members array
	 * @param scores	//Array of normalized scores of the team
	 */
	public screen3(String[] members, double[] scores) {
		set_screen(members,scores);
		
	}
	
	/**
	 * Setting display screen with team members and normalized scores
	 * @param members	//Team members array
	 * @param scores	//Array of normalized scores of the team
	 */
	public void set_screen(String[] members, double[] scores) {
		frame =  new JFrame();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3,1,0,0));
	  	JLabel head = new JLabel("Normalised scores",JLabel.CENTER);

		for(int i=0;i<members.length;i++) {
			memlabels[i] = new JLabel(members[i]);
		}
		for(int i=0;i<scores.length;i++) {
			scorelabels[i] = new JLabel(Double.toString(scores[i]));
		}
		
        
		panel0 = new JPanel();
        panel0.setLayout(new GridLayout(7,1));
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(7,1));
        for(int i=0;i<members.length;i++) {
        	panel1.add(memlabels[i]);
        }
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(7,1));
        for(int i=0;i<scores.length;i++) {
        	panel2.add(scorelabels[i]);
        }
        panel = new JPanel();
		
        panel.setLayout(new GridLayout(1,2,0,0));
        panel.add(panel0);
        panel.add(panel1);
        panel.add(panel2);
        
        
  	  	head.setMaximumSize(head.getPreferredSize());

        frame.add(head);
  	  	panel.setMaximumSize(panel.getPreferredSize());

        frame.add(panel);
  	  	frame.setVisible(true);
	}

}
