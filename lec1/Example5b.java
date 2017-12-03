import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * This is a better solution when using two {@code JButton}s. It creates and
 * attaches an ActionListener for each. It also raises the question of what
 * would happen if we use a single instance to listen to each button...
 *
 * @author Matthew Hertz
 */
public class Example5b {
	/**
	 * Create a new window containing the buttons.
	 */
	public Example5b() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton button = new JButton("Click me!"); // Look, no fields!
		JButton otherButton = new JButton("Or me!"); // Still no fields!

		ActionListener control = new Listener5b();
		button.addActionListener(control);
		ActionListener otherControl = new Listener5b();
		otherButton.addActionListener(control); // What would happen if
														// this used
														// control?
		otherButton.addActionListener(otherControl);
		frame.add(BorderLayout.EAST, button);
		frame.add(BorderLayout.WEST, otherButton);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Start the program (I ran out of button jokes, sorry!)
	 *
	 * @param args
	 *            Command-line arguments which we will ignore.
	 */
	public static void main(String[] args) {
		Example5b example = new Example5b();
	}
}