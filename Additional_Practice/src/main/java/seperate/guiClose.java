/**MUST USE LINES TO CLOSE A FRAME.*
 	*-1   Frame1.addWindowListener(this);
		  **It should be inside the constructor.
	*-2   public void windowClosing(WindowEvent e)\
					{
					  frame1.dispose();
			        }
					**It must be outside the constructor.
	*-3 import java.awt.Events.*;
    *-4 import java.awt.*;
*/
import java.awt.*;  
import java.awt.event.*;  
class GuiClose extends WindowAdapter {  
    Frame f;  
    GuiClose(){  
        f=new Frame("guiClose...");  
        f.addWindowListener(this);  
          
        f.setSize(400,400);  
        f.setLayout(null);  
        f.setVisible(true);  
    }  
	
	
		public void windowClosing(WindowEvent e)
		{  
		  f.dispose();  
		}  
 public static void main(String[] args) {  
  GuiClose  obj=new GuiClose();  
}  
}  