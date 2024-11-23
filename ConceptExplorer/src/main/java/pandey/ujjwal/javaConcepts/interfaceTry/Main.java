package pandey.ujjwal.javaConcepts.interfaceTry;

class Main implements Components {

  Components ff;
  static Main obj = new Main();

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
  public void lights() {}
}
