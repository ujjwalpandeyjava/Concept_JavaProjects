package pandey.ujjwal.javaConcepts.interfaceShapes.pack3;
import pandey.ujjwal.javaConcepts.interfaceShapes.interfaces.Shapes;

public class Rectangle implements Shapes {
	
	@Override
	public void input() {
		System.out.println("It is Rectangle input.");
	}

	@Override
	public void area() {
		System.out.println("It is Rectangle area.");	
	}

	@Override
	public void perameters() {
		System.out.println("It is Rectangle paremeteres.");	
		
	}

	@Override
	public void filled() {
		System.out.println("It is Rectangle filled yes or no.");	
		
	}
}
