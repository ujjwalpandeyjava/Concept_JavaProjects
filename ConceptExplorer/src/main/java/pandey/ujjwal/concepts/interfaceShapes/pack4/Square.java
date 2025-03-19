package pandey.ujjwal.concepts.interfaceShapes.pack4;

import pandey.ujjwal.concepts.interfaceShapes.interfaces.Shapes;

public class Square implements Shapes {
	
	@Override
	public void input() {
		System.out.println("It is Square input.");
	}

	@Override
	public void area() {
		System.out.println("It is Circle area.");	
	}

	@Override
	public void perameters() {
		System.out.println("It is Circle paremeteres.");	
		
	}

	@Override
	public void filled() {
		System.out.println("It is Circle filled yes or no.");	
		
	}
}
