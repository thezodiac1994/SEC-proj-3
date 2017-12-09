import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



  
public class screen2 extends JPanel {
    private boolean DEBUG = false;
    static int memberCount=0;
	static boolean previouslyFilled=false;
    static JPanel panel3 = new JPanel();
    static JTable table = new JTable();
    static JFrame frame = new JFrame("SimpleTableDemo");
//    static Double[] results = new Double[];


    public screen2(int x, boolean y) {
    	super(new GridLayout(1,0));
 
       	memberCount = x;
		previouslyFilled = y;
       	System.out.println(memberCount + " " + previouslyFilled);
    }

    public void initialize_frame (JFrame frame){
        
        frame.setTitle("Software engineering peer evaluation system");  
        frame.setSize(500, 300);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLayout(new GridLayout(4,1));
        JLabel head = new JLabel("Welcome to peer evaluation system",JLabel.CENTER);
        frame.add(Box.createRigidArea(new Dimension(3,0)));
        frame.add(head);
        
    }


    public double[] normalize (int [][] scores){
        
        double[] normalized_score = new double[scores.length];

        int total = 0;
        for (int i=0;i<scores.length;i++)
            for(int j=0;j<scores[0].length;j++)
                total = total + scores[i][j];


        for(int i=0;i<scores.length;i++){
            int current_sum = 0;

            for(int j=0;j<scores[0].length; j++)
                current_sum = current_sum + scores[i][j];


            normalized_score[i] = current_sum / total;

        }

        return normalized_score;

    }


    public void create_table(){
       	String[] columnNames = {"#","Name",
                        "Professionalism",
                        "Participation",
                        "Work Evaluation",
                        };                    


	    Object[][] bank = {
	    {new Integer(1),"John", new Double(5), new Double(4), new Double(5)},
	    {new Integer(2),"Shavon", new Double(5), new Double(4), new Double(5)},
	   	{new Integer(3),"Mike", new Double(5), new Double(4), new Double(5)},
	   	{new Integer(4),"Gordon", new Double(5), new Double(4), new Double(5)},
	   	{new Integer(5),"Liz", new Double(5), new Double(4), new Double(5)},
	   	{new Integer(6),"Karen", new Double(5), new Double(4), new Double(5)},
	   	{new Integer(7),"Rob", new Double(5), new Double(4), new Double(5)}
		};

		Object[][] data = new Object[memberCount][5];

		if(previouslyFilled==true){
			for (int i=0;i<memberCount;i++)
				for(int j=0;j<5;j++){
					data[i][j] = bank[i][j];
					System.out.println(data[i][j]);
				}

		}
        
        this.table = new JTable(data, columnNames);
        this.table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        this.table.setFillsViewportHeight(true);
 
        if (DEBUG) {
            this.table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }
 
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(this.table);
 
        //Add the scroll pane to this panel.
        add(scrollPane);
    }
    









    private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();
 
        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public static void createAndShowGUI() {
        //Create and set up the window.

        //Create and set up the content pane.
        screen2 obj = new screen2(memberCount,previouslyFilled); // set this to 5 just for testing purposes -> this value needs to be extracted from function call
        
        obj.setOpaque(true); //content panes must be opaque
//      frame.setContentPane(newContentPane);
        //Display the window.
        obj.initialize_frame(obj.frame);
        obj.create_table();
        obj.frame.add(table);
        obj.frame.pack();
        JButton submit = new JButton("Submit");
        obj.frame.add(submit);
        //submit.addActionListener(this);
        obj.frame.setVisible(true);
    }

/*
    public void actionPerformed(ActionEvent arg0) {
        //System.out.println(membersCount + " " + flag);
        this.frame.setVisible(false);

        String s = comboBox.getSelectedItem().toString();
        int x = Integer.parseInt(s);
        boolean flag = checkbox.isSelected();
        screen2 obj = new screen2(x,flag);
        obj.createAndShowGUI();
    

    }
*/ 
    
}
