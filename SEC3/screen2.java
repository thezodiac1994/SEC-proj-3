package sec;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

public class screen2 extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean DEBUG = false;
	static int memberCount = 0;
	static boolean previouslyFilled = false;
	static JPanel panel3 = new JPanel();
	static JTable table = new JTable();
	static JFrame frame = new JFrame();

	public void initialize_frame(JFrame frame) {

		frame.setTitle("Software engineering peer evaluation system");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(4, 1));
		JLabel head = new JLabel("Peer evaluation form", JLabel.CENTER);
		//frame.add(Box.createRigidArea(new Dimension(3, 0)));
		frame.add(head);

	}

	public screen2() {

	}

	public screen2(int x, boolean y) {
		super(new GridLayout(1, 0));

		memberCount = x;
		previouslyFilled = y;
		System.out.println(memberCount + " " + previouslyFilled);
	}

	public void create_table() {
		String[] columnNames = { "#", "Name", "Professionalism", "Participation", "Work Evaluation", };

		Object[][] bank = { { new Integer(1), "John", new Integer(5), new Integer(4), new Integer(5) },
				{ new Integer(2), "Shavon", new Integer(5), new Integer(4), new Integer(5) },
				{ new Integer(3), "Mike", new Integer(5), new Integer(4), new Integer(5) },
				{ new Integer(4), "Gordon", new Integer(5), new Integer(4), new Integer(5) },
				{ new Integer(5), "Liz", new Integer(5), new Integer(4), new Integer(5) },
				{ new Integer(5), "Scott", new Integer(4), new Integer(5), new Integer(5) },
				{ new Integer(6), "Rob", new Integer(5), new Integer(4), new Integer(5) },
				{ new Integer(7), "Pretty", new Integer(5), new Integer(4), new Integer(5) }};

		Object[][] data = new Object[memberCount][5];

		Integer[] scoreList = new Integer[] { 0, 1, 2, 3, 4, 5 };

		if (previouslyFilled == true) {
			for (int i = 0; i < memberCount; i++)
				for (int j = 0; j < 5; j++) {
					data[i][j] = bank[i][j];
				}

		} else
			for (int i = 0; i < memberCount; i++) {
				data[i][0] = bank[i][0];
				data[i][1] = bank[i][1];
				for (int j = 2; j < 5; j++) {
					data[i][j] = null;
				}
			}

		DefaultTableModel model = new DefaultTableModel(data, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column == 1 || column == 0)
					return false;
				return true;
			}
		};

		this.table = new JTable(data, columnNames);
		table.setModel(model);

		this.table.setPreferredScrollableViewportSize(new Dimension(500, 200));
		this.table.setFillsViewportHeight(true);
		this.table.setRowHeight(30);
			    
		for (int i = 2; i < 5; i++) {
			JComboBox<Integer> myComboBox = new JComboBox<Integer>(scoreList);
			this.table.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(myComboBox));
		}

		if (DEBUG) {
			this.table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					printDebugData(table);
				}
			});
		}
	}

	private void printDebugData(JTable table) {
		int numRows = table.getRowCount();
		int numCols = table.getColumnCount();
		javax.swing.table.TableModel model = table.getModel();

		System.out.println("Value of data: ");
		for (int i = 0; i < numRows; i++) {
			System.out.print("    row " + i + ":");
			for (int j = 0; j < numCols; j++) {
				System.out.print("  " + model.getValueAt(i, j));
			}
			System.out.println();
		}
		System.out.println("--------------------------");
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	public void createAndShowGUI() {
		// Create and set up the window.

		// Create and set up the content pane.
		screen2 obj = new screen2(memberCount, previouslyFilled);
		obj.setOpaque(true); // content panes must be opaque
		// frame.setContentPane(newContentPane);
		// Display the window.
		obj.initialize_frame(obj.frame);
		obj.create_table();
		obj.frame.add(new JScrollPane(table));
		obj.frame.pack();
		JButton submit = new JButton("Submit");
		panel3.add(submit);
		obj.frame.add(panel3);
		submit.addActionListener(this);
		obj.frame.setVisible(true);
	}

	public double[] normalize(int[][] scores) {

		double[] normalized_score = new double[scores.length];

		int total = 0;
		for (int i = 0; i < scores.length; i++)
			for (int j = 0; j < scores[0].length; j++)
				total = total + scores[i][j];

		// the GUI needs to handle this case and raise and error when all
		// entries are 0.
		// even if the normalization function gets all 0s, it should throw and
		// exception
		if (total == 0)
			throw new ArithmeticException("All entries cant be zero");

		for (int i = 0; i < scores.length; i++) {
			int current_sum = 0;

			for (int j = 0; j < scores[0].length; j++)
				current_sum = current_sum + scores[i][j];	
			double a = (current_sum * 1.0) / (total * 1.0);
			normalized_score[i] = Math.floor(a *100)/100;
			//normalized_score[i] = (current_sum * 1.0) / (total * 1.0);


		}

		// debug only
		for (int i = 0; i < scores.length; i++)
			System.out.println(i + " the score normalized = " + normalized_score[i]);

		return normalized_score;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int numRows = table.getRowCount();
		javax.swing.table.TableModel model = table.getModel();

		boolean isNull = false;

		int[][] scores = new int[numRows][3];
		String[] members = new String[scores.length];
		
		int sum = 0;

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < 3; j++) {
				Object value = model.getValueAt(i, j + 2);

				if (value != null && (Integer) value != 0) {
					scores[i][j] = (Integer) value;
				}
				else if(value == null)
				{
					isNull = true;
				}
				
				if(value != null)
					sum = sum + (Integer) value;
			}
			members[i] = (String)model.getValueAt(i, 1);
		}

		for (int i =0 ; i<numRows; i++)
			System.out.println(members[i]);
		
		if (isNull)
			JOptionPane.showMessageDialog(null, "Please enter all the scores");
		else if(sum == 0)
			JOptionPane.showMessageDialog(null, "All the scores cannot be 0. Please enter valid scores");

		if (!isNull && sum != 0){
			double[] normalized_scores = new double[scores.length];
			
			normalized_scores = normalize(scores);
			screen2 object = new screen2();
			object.frame.setVisible(false);
			screen3 screen = new screen3(members, normalized_scores);
		}
	}
}