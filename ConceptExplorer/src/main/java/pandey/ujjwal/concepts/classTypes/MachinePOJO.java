package pandey.ujjwal.concepts.classTypes;

public class MachinePOJO {
	private int id;
	static String staticMember = "Static memeber";

	public MachinePOJO(int id) {
		super();
		this.id = id;
	}

	public void work() {
		System.out.println("Machine '" + id + "' is working.");

		var inner = new Inner();
		inner.display();

		var snc = new StaticNested();
		snc.display();
	}

	/**
	 * It can access the outer class's static members and instance members too.
	 */
	class Inner {
		void display() {
			System.out.println("This is a member inner class for machine: " + id + staticMember);

			/**
			 * It is only accessible within that block.
			 */
			class LocalInner {
				void display() {
					System.out.println("This is a local inner class.");
				}
			}
			LocalInner local = new LocalInner();
			local.display();
		}
	}

	/**
	 * It can access the outer class's static members but not the instance members.
	 */
	static class StaticNested {
		void display() {
			System.out.println("This is a static nested class :" + staticMember);
		}
	}
}
