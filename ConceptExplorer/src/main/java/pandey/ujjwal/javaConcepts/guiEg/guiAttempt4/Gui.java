package pandey.ujjwal.javaConcepts.guiEg.guiAttempt4;

// mistakes but still Working
//Two of buttons not appear without hovering
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

class Gui extends WindowAdapter implements ActionListener {
	Frame f;
	Label l1, l2, l3;
	TextField t1, t2, t3;
	Checkbox cb1, cb2;
	JButton b11, b22, b33, add, clear;
	TextArea ta;
	List lt;
	Choice ch;

	Gui() {
		f = new Frame("Custome material...");
		f.addWindowListener(this);
		f.setVisible(true);
		f.setSize(700, 800);
		f.setLayout(null);
		// f.setBackground(Color.GRAY);
//Label
		l1 = new Label("Number 1");
		l1.setBounds(50, 60, 100, 30);
		l2 = new Label("Number 2");
		l2.setBounds(50, 110, 100, 30);
		l3 = new Label("Addition is: ");
		l3.setBounds(50, 160, 100, 30);
//TextField	
		t1 = new TextField();
		t1.setBounds(160, 60, 200, 30);
		t2 = new TextField();
		t2.setBounds(160, 110, 200, 30);
		t3 = new TextField();
		t3.setBounds(160, 160, 200, 30);
//Buttons
		add = new JButton("Add");
		add.setBounds(80, 220, 70, 30);
		add.addActionListener(this);
		clear = new JButton("Clear");
		clear.setBounds(80, 260, 70, 30);
		b11 = new JButton("Pink");
		b11.setBounds(400, 400, 80, 30);
		b22 = new JButton("Blue");
		b22.setBounds(400, 450, 80, 30);
		b33 = new JButton("Green");
		b33.setBounds(400, 500, 80, 30);

//Checkbox
		cb1 = new Checkbox("one");
		cb1.setBounds(150, 200, 40, 20);
		cb2 = new Checkbox("two");
		cb2.setBounds(230, 200, 40, 20);
//List
		lt = new List();
		lt.setBounds(200, 300, 80, 40);
//Choice
		ch = new Choice();
		ch.setBounds(300, 300, 200, 40);
//TextArea	 
		ta = new TextArea("Type here");
		ta.setBounds(200, 350, 100, 150);

//Adding the elements and actions
		b11.addActionListener(this);
		b22.addActionListener(this);
		b33.addActionListener(this);
		clear.addActionListener(this);

		f.add(l1);
		f.add(t1);
		f.add(l2);
		f.add(t2);
		f.add(l3);
		f.add(t3);
		f.add(add);
		f.add(clear);
		f.add(b11);
		f.add(b22);
		f.add(b33);

		f.add(ch);
		ch.add("Activate Tiger 101");
		ch.add("Activate Tiger 102");
		ch.add("Activate Tiger 103");
		ch.add("Activate Tiger 104");
		f.add(lt);
		lt.add("Item 1");
		lt.add("Item 2");
		lt.add("Item 3");
		lt.add("Item 4");
		f.add(cb1);
		f.add(cb2);
		f.add(ta);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * //Works on the string on the button String s = e.getActionCommand();
		 * if(s.equals("Red")) f.setBackground(Color.RED); else if(s.equals("Green"))
		 * f.setBackground(Color.GREEN); else if(s.equals("Blue"))
		 * f.setBackground(Color.YELLOW);
		 */
		// Works on the button
		if (e.getSource() == b11)
			f.setBackground(Color.pink);
		else if (e.getSource() == b22)
			f.setBackground(Color.GREEN);
		else if (e.getSource() == b33)
			f.setBackground(Color.BLUE);
		if (e.getSource() == add) {
			try {
				float a, b, c;
				a = Float.parseFloat(t1.getText());
				b = Float.parseFloat(t2.getText());
				c = a + b;
				t3.setText(Float.toString(c));
			} catch (Exception ty) {
				System.out.println("tytyty " + ty);
			}
		}
		if (e.getSource() == clear) {
			t1.setText(null);
			t2.setText(null);
			t3.setText(null);
		}
	}

	public void windowClosing(WindowEvent e) {
		f.dispose();
	} // with swing no need
}