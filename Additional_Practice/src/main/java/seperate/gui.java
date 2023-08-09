import java.awt.*;
class MyFrame
{
	Frame fr;
	Panel pan;
	Button btn;
	public MyFrame()
	{
		fr = new Frame ("Window... ");
		fr.setSize(400,400);
		
		pan = new Panel ();
		pan.setSize(300,300);
		pan.setVisible(true);
		pan.setBackground(Color.RED);
		
		btn = new Button("Hello");
		btn.setBounds(30,30,50,50);
		fr.add(btn);	

//		fr.add(pan);
		fr.setVisible(true);
	}
}
class TestFrame
{
	public static void main(String ar[])
	{
		MyFrame ob = new MyFrame();
	}

}
