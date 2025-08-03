package pandey.ujjwal.concepts.interfaceEg;

public class InterfaceTry implements Components {

  static Components obj = new InterfaceTry();

  public static void main(String sa[]) {
    obj.tyres("Heavy tires");
    obj.numberOfSeats(5);
  }

  @Override
  public void tyres(String x) {
    System.out.println(x);
  }

  @Override
  public void numberOfSeats(int x) {
    System.out.println("Number of seats in the vehicle are:= " + x);
  }

  @Override
  public void lights() {
    System.out.println("Lights method called");
  }
}

interface Components {
  public void tyres(String x);

  public void numberOfSeats(int x);

  public void lights();
}
