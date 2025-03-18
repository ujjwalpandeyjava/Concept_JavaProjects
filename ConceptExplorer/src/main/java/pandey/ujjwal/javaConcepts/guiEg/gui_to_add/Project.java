package pandey.ujjwal.javaConcepts.guiEg.gui_to_add;

//Leave it now work on the swing package or jmaterials...
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class myframe extends WindowAdapter {
	Frame fr;
	Button b1, b2;
	Label l1, l2, l3, l4, l5, l6;
	Panel p1, p2, p3, p4, p5, p6, p7;

	myframe() {
		// *setType(Type.POPUP);
		// fr.setResizable(false);
		fr = new Frame("Working...");
		fr.setBackground(Color.BLUE);
		fr.addWindowListener(this);// to run window closing...

		// Panel adding.
		p1 = new Panel();
		p1.setBounds(15, 39, 600, 61);
		p1.setBackground(Color.CYAN);
		p2 = new Panel();
		p2.setBounds(15, 100, 148, 337);
		p2.setBackground(Color.CYAN);
		p3 = new Panel();
		p3.setBounds(178, 115, 215, 80);
		p3.setBackground(Color.WHITE);
		/**/l3 = new Label("This is to check it's working.");
		// l3.setLayout(flow);
		l3.setBounds(150, 80, 60, 100);
		l3.setBackground(Color.WHITE);
		l4 = new Label("Label4");
		l4.setBounds(20, 80, 60, 30);
		l4.setBackground(Color.WHITE);
		l5 = new Label("Label5");
		l5.setBounds(20, 80, 60, 30);
		l5.setBackground(Color.WHITE);
		l6 = new Label("Label6");
		l6.setBounds(20, 80, 60, 30);
		l6.setBackground(Color.WHITE);

		p4 = new Panel();
		p4.setBounds(404, 115, 210, 80);
		p4.setBackground(Color.WHITE);
		p5 = new Panel();
		p5.setBounds(178, 205, 215, 80);
		p5.setBackground(Color.WHITE);
		p6 = new Panel();
		p6.setBounds(404, 205, 210, 80);
		p6.setBackground(Color.WHITE);
		p7 = new Panel();
		p7.setBounds(178, 295, 435, 142);
		p7.setBackground(Color.WHITE);

		// button
		b1 = new Button("click 1");
		b1.setBounds(20, 20, 100, 90);
		b1.setBackground(Color.YELLOW);
		b2 = new Button("click 2");
		b2.setBounds(100, 40, 60, 30);
		b2.setBackground(Color.YELLOW);

		// Label
		l1 = new Label("Label 1");
		l1.setBounds(20, 80, 60, 30);
		l1.setBackground(Color.YELLOW);
		l2 = new Label("Label 2");
		l2.setBounds(100, 80, 60, 30);
		l2.setBackground(Color.YELLOW);

		p2.add(b1);
		p2.add(b2);
		p2.add(l1);
		p2.add(l2);
		fr.add(p1);
		fr.add(p2);
		fr.add(p3);
		fr.add(p4);
		fr.add(p5);
		fr.add(p6);
		fr.add(p7);

		p3.add(l5);
		p3.add(l6);
		p3.add(l3);
		p3.add(l4);

		fr.setSize(626, 450);
		fr.setLayout(null);
		fr.setVisible(true);
	}

	public void windowClosing(WindowEvent w) {
		fr.dispose();
	}
}

class Project {
	public static void main(String as[]) {
		new myframe();
	}
}