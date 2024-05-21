package pandey.ujjwal.javaConcepts.guiEg;

//Working
import java.awt.*;
import java.awt.event.*;

class Gui extends WindowAdapter {
	Frame f;
	Label b1, b2, b3;
	TextField t1, t2, t3;

	Gui() {
		f = new Frame("Working...");
		f.addWindowListener(this);

		f.setVisible(true);
		f.setSize(500, 400);
		f.setBackground(Color.BLUE);
		f.setLayout(null);

		b1 = new Label("Number 1");
		b1.setBounds(50, 60, 100, 30);
		f.add(b1);
		b2 = new Label("Number 2");
		b2.setBounds(50, 110, 100, 30);
		f.add(b2);
		b3 = new Label("Add");
		b3.setBounds(50, 160, 100, 30);
		f.add(b3);

		t1 = new TextField("NO it is not working.");
		t1.setBounds(160, 60, 200, 30);
		f.add(t1);
		t2 = new TextField();
		t2.setBounds(160, 110, 200, 30);
		f.add(t2);
		t3 = new TextField();
		t3.setBounds(160, 160, 200, 30);
		f.add(t3);
	}

	public void windowClosing(WindowEvent e) {
		f.dispose();
	}
}

class Gui4 {
	public static void main(String as[]) {
		new Gui();
	}
}