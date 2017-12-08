import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



  
public class screen2 extends JPanel {
    private boolean DEBUG = false;
    static int memberCount=0;
	static boolean previouslyFilled=false;

    public screen2()
    {

    }
 
    public screen2(int x, boolean y) {
    	super(new GridLayout(1,0));
 
       	memberCount = x;
		previouslyFilled = y;
       	System.out.println(memberCount + " " + previouslyFilled);

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
 
        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
 
        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }
 
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
 
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
        JFrame frame = new JFrame("SimpleTableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
         screen2 newContentPane = new screen2(memberCount,previouslyFilled); // set this to 5 just for testing purposes -> this value needs to be extracted from function call
        
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
