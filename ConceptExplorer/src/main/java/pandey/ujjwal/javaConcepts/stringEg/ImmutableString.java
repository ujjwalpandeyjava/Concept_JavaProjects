package pandey.ujjwal.javaConcepts.stringEg;

public class ImmutableString {
	public static void main(String f[]) {
		String n = "this is  jg\n";
		System.out.println(n + n.hashCode());
		n += "this is  jg\n";
		System.out.println(n + n.hashCode());
	}
}