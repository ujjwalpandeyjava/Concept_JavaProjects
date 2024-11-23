package pandey.ujjwal.javaConcepts.interfaceShapes.pack2;

import pandey.ujjwal.javaConcepts.interfaceShapes.interfaces.Shapes;

public class Circle implements Shapes{
public void input() {
	System.out.println("It is Circle input.");
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
