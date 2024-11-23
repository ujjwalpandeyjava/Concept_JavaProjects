package pandey.ujjwal.javaConcepts.countdownTimer;

import java.awt.Color;
import javax.swing.*;

public class CountdownTimer extends Thread {
	public void run() {
		buildGUI();
	}

	public void display() {
		for (int i = 6; i >= 0; i--) {
			try {
				String timeToEnd = Integer.toString(i);
				tf.setText(timeToEnd + " Seconds to go...");
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e + "\n done...");
			}
		}
		JOptionPane.showMessageDialog(fr, "Times up!!!!");
	}

	JFrame fr;
	JPanel p;
	JTextField tf;
	JLabel l;

	public void buildGUI() {
		fr = new JFrame("Countdown Timer...");
		p = new JPanel();
		p.setBackground(Color.BLUE);
		l = new JLabel("");
		tf = new JTextField(15);
		tf.setEditable(false);
		tf.setBackground(Color.gray);
		fr.add(p);
		p.add(tf);
		p.add(l);
		fr.setVisible(true);
		fr.setSize(500, 500);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// fr.setLayout(null);
		display();
	}

	public static void main(String[] ass) {
		CountdownTimer obj = new CountdownTimer();
		obj.start();
		// Use obj.buildGUI when there are no threads...
	}
}
