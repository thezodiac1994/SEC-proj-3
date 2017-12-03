import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Our sixth example class.
 *
 * @author Matthew Hertz
 */
public class ColorTextOnClick extends JFrame {

	/** The text for our screen. */
	private JLabel label;

	/**
	 * Create a new window containing the button.
	 */
	public ColorTextOnClick() {
		super("GUI sounds dirty");
		JButton redButton = new JButton("Red");
		redButton.addActionListener(new ButtonListen(Color.RED));

		JButton greenButton = new JButton("Green");
		greenButton.addActionListener(new ButtonListen(Color.GREEN));

		JButton blueButton = new JButton("Blue");
		blueButton.addActionListener(new ButtonListen(Color.BLUE));

		label = new JLabel("I hold text");
		Dimension d = new Dimension(30, 30);
		redButton.setMinimumSize(d);
		add(BorderLayout.SOUTH, redButton);
		add(BorderLayout.EAST, greenButton);
		add(BorderLayout.WEST, blueButton);
		add(BorderLayout.CENTER, label);

		pack();
		setVisible(true);
	}

	/**
	 * Create the window with the buttons.
	 *
	 * @param args
	 *            Command-line arguments which we will ignore.
	 */
	public static void main(String[] args) {
		Example6a example = new Example6a();
		// Set the example's close operation, size, and then make it visible
		example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		example.pack();
		example.setVisible(true);
	}

	public class ButtonListen implements ActionListener {
		private Color theColor;
		
		public ButtonListen(Color c) {
			theColor = c;
		}
		
		/**
		 * This method is required by ActionListener. It will be called whenever an
		 * object to which we are listening generates an event.
		 *
		 * @param arg0
		 *            Action event that has just been triggered.
		 */
		public void actionPerformed(ActionEvent arg0) {
			label.setForeground(theColor);
		}
	}
}
