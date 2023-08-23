package guiEg.guiAttempt2;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 2949944071586269134L;
	int action;
	double a, b, result = 0;
	String f;
	JFrame fr;
	JPanel p1, p2, p3;
	JTextField tf;
	JLabel l1;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, b00;
	JButton buttonadd, buttonsub, buttonmul, buttondiv, buttoneql, buttondot;
	JButton buttonclr, buttondel;

	public GUI() {
		fr = new JFrame("Calculator by ujjwal");
		fr.setLocation(90, 90);
		fr.getContentPane().setBackground(Color.LIGHT_GRAY); // not working

		// Panels
		p1 = new JPanel();
		p1.setBounds(0, 0, 400, 80);
		p1.setBackground(new Color(60, 64, 64));
		p2 = new JPanel();
		p2.setBounds(1, 120, 382, 340);
		p2.setBackground(Color.DARK_GRAY);
		p2.setFont(new Font("Serif_bold", Font.BOLD, 18));
		/*
		 * p3 = new JPanel(); p3.setBounds(1, 120, 382, 340);
		 * p3.setBackground(Color.DARK_GRAY); p3.setFont(new
		 * Font("Serif_bold",Font.BOLD,18));
		 */
		// TextField
		tf = new JTextField("");
		tf.setBounds(10, 10, 363, 50);
		tf.setFont(new Font("Serif_bold", Font.BOLD, 24));
		// Label
		l1 = new JLabel("Perform calculation actions: ");
		l1.setBounds(10, 90, 200, 20);
		// Numeric buttons
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		b0 = new JButton("0");
		b00 = new JButton("00");
		// Action buttons
		buttonadd = new JButton("+");
		buttonsub = new JButton("-");
		buttonmul = new JButton("*");
		buttondiv = new JButton("/");
		buttoneql = new JButton("=");
		buttondot = new JButton(".");
		buttonclr = new JButton("CE");
		buttonclr.setBounds(210, 85, 75, 30);
		buttondel = new JButton("<");
		buttondel.setBounds(300, 85, 75, 30);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		buttonadd.addActionListener(this);
		buttonsub.addActionListener(this);
		buttonmul.addActionListener(this);
		buttondiv.addActionListener(this);
		buttoneql.addActionListener(this);
		buttondot.addActionListener(this);
		buttonclr.addActionListener(this);
		buttondel.addActionListener(this);

		// Adding elements
		// Elements layout
		fr.setLayout(null);
		p1.setLayout(null);

		fr.add(p1);
		p1.add(tf);
		fr.add(p2);
		// fr.add(p3);

		p2.setLayout(new GridLayout(4, 3, 2, 2));
		p2.add(b9);
		p2.add(b8);
		p2.add(b7);
		p2.add(buttondiv);
		p2.add(b6);
		p2.add(b5);
		p2.add(b4);
		p2.add(buttonmul);
		p2.add(b3);
		p2.add(b2);
		p2.add(b1);
		p2.add(buttonsub);
		p2.add(buttondot);
		p2.add(b0);
		p2.add(buttonadd);
		p2.add(buttoneql);
		fr.add(l1);

		fr.add(buttonclr);
		fr.add(buttondel);

		fr.setVisible(true);
		fr.setSize(400, 500);
		fr.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// putting numbers on the textfield
		if (e.getSource() == b9) {
			tf.setText(tf.getText().concat(b9.getText()));
		}
		if (e.getSource() == b8) {
			tf.setText(tf.getText().concat(b8.getText()));
		}
		if (e.getSource() == b7) {
			tf.setText(tf.getText().concat(b7.getText()));
		}
		if (e.getSource() == b6) {
			tf.setText(tf.getText().concat(b6.getText()));
		}
		if (e.getSource() == b5) {
			tf.setText(tf.getText().concat(b5.getText()));
		}
		if (e.getSource() == b4) {
			tf.setText(tf.getText().concat(b4.getText()));
		}
		if (e.getSource() == b3) {
			tf.setText(tf.getText().concat(b3.getText()));
		}
		if (e.getSource() == b2) {
			tf.setText(tf.getText().concat(b2.getText()));
		}
		if (e.getSource() == b1) {
			tf.setText(tf.getText().concat(b1.getText()));
		}
		if (e.getSource() == b0) {
			tf.setText(tf.getText().concat(b0.getText()));
		}
		if (e.getSource() == buttondot) {
			tf.setText(tf.getText().concat(buttondot.getText()));
		}
		// On action performed
		if (e.getSource() == buttonadd) {
			a = Double.valueOf(tf.getText());
			tf.setText("");
			action = '+';
		}
		if (e.getSource() == buttonsub) {
			a = Double.valueOf(tf.getText());
			tf.setText("");
			action = '-';
		}
		if (e.getSource() == buttonmul) {
			a = Double.valueOf(tf.getText());
			tf.setText("");
			action = '*';
		}
		if (e.getSource() == buttondiv) {
			a = Double.valueOf(tf.getText());
			tf.setText("");
			action = '/';
		}
		if (e.getSource() == buttonclr) {
			a = b = result = 0;
			f = "";
			tf.setText("");
		}
		if (e.getSource() == buttondel) {
			f = tf.getText();
			f = f.substring(0, f.length() - 1);
			tf.setText(f);
		}
		// ON pressing '='
		if (e.getSource() == buttoneql) {
			switch (action) {
			case '+':
				b = Double.valueOf(tf.getText());
				if (tf.getText() == "") {
					b = 0;
				}
				result = a + b;
				tf.setText(String.valueOf(result));
				break;
			case '-':
				b = Double.valueOf(tf.getText());
				if (tf.getText() == "") {
					b = 0;
				}
				result = a - b;
				tf.setText(String.valueOf(result));
				break;
			case '*':
				b = Double.valueOf(tf.getText());
				if (tf.getText() == "") {
					b = 0;
				}
				result = a * b;
				tf.setText(String.valueOf(result));
				break;
			case '/':
				b = Double.valueOf(tf.getText());
				if (tf.getText() == "") {
					b = 0;
				}
				result = a / b;
				tf.setText(String.valueOf(result));
				break;
			}
		}
	}

	public static void main(String[] args) {
		new GUI();
	}
}
