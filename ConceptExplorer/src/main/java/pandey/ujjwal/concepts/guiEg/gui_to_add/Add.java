package pandey.ujjwal.concepts.guiEg.gui_to_add;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Add extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	// Global variables
	JFrame fr;
	JLabel l1, l2, l3;
	JTextField tf1, tf2, tf3;
	JButton b1, b2;

	public Add() { // constructor
		fr = new JFrame("ADDITION"); // Title of the program
		l1 = new JLabel("ENTER THE FIRST NUMBER");
		l1.setBounds(360, 95, 180, 30);
		l2 = new JLabel("ENTER THE THIRD NUMBER");
		l2.setBounds(360, 135, 180, 30);
		l3 = new JLabel("SUM OF TWO NUMBER");
		l3.setBounds(360, 175, 180, 30);

		tf1 = new JTextField();
		tf1.setBounds(550, 100, 170, 20);
		tf2 = new JTextField();
		tf2.setBounds(550, 140, 170, 20);
		tf3 = new JTextField();
		tf3.setBounds(550, 180, 170, 20);

		b1 = new JButton("ADD");
		b1.setBounds(360, 220, 80, 30);
		b1.addActionListener(this);
		b2 = new JButton("CLEAR");
		b2.setBounds(360, 270, 80, 30);
		// object of the an operation
		fr.add(l1);
		fr.add(l2);
		fr.add(l3);
		fr.add(tf1);
		fr.add(tf2);
		fr.add(tf3);
		fr.add(b1);
		fr.add(b2);

		fr.setLayout(null); // place before adding components
		fr.setSize(800, 500);
		fr.setResizable(false); // Frame size
		fr.setVisible(true);
		b1.addActionListener(this);
		b2.addActionListener(this);
		/*
		 * //window close operation addWindowListener(new WindowAdapter() { public void
		 * windowClosing(WindowEvent we) { System.exit(0); } });
		 */
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {
			float a, b, c;
			a = Float.parseFloat(tf1.getText());
			b = Float.parseFloat(tf2.getText());
			c = a + b;
			tf3.setText(Float.toString(c));
		} else if (ae.getSource() == b2) {

			try {
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
			} catch (Exception e) {
				tf1.setText("Please enter something...");
				System.out.println("Please enter something...");
			}

		}
	}
}