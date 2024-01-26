package testing.jUnit4;
/*
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;*/

/*
	<!-- https://mvnrepository.com/artifact/junit/junit -->
	<dependency>
	    <groupId>junit</groupId>
	    <artifactId>junit</artifactId>
	    <version>4.13.2</version>
	    <scope>test</scope>
	</dependency>
*/

//JUnit 4, introduced in 2006, key annotations and classes
public class JUnit4_EgTest {
	JUnit4_Eg jUnit4_EgClassEg = new JUnit4_Eg();
/*
	// Assertion Methods:
	static {
		System.out.println("Inside static");
		// Asserts that two values are equal.
		Assert.assertEquals("", "");

		// Asserts that a condition is true.
		Assert.assertTrue(isReturnTrue());

		// Asserts that a condition is false.
		Assert.assertFalse(!isReturnTrue());

		// Asserts that an object is not null.
		Assert.assertNotNull(isReturnTrue());

		// Asserts that an object is null.
//		Assert.assertNull(isReturnTrue());
		Assert.assertNull(null);

		// Asserts that two arrays are equal.
		int[] actualArray = {};
		int expectedArray[] = {};
		int expectedArray1[] = { 1, 2 };
		Assert.assertArrayEquals(expectedArray, actualArray);
//		Assert.assertArrayEquals(expectedArray1, actualArray); // Failing this will not let the methods work...
	}

	private static boolean isReturnTrue() {
		return true;
	}

//	 Marks a method as a test method.
	@Test
	public void simpleMethodTest() {
		// Test logic here
		System.out.println("@Test");
		jUnit4_EgClassEg.simpleMethod();
	}

//	Before each test method.
	@Before
	public void setUp() {
		System.out.println("Initialization logic before each test");
	}

//	After each test method.
	@After
	public void tearDown() {
		System.out.println("Cleanup logic after each test");
	}

	// Executed once before any test methods in the class.
	@BeforeClass
	public static void setUpClass() {
		System.out.println("One-time class based initialization logic");
	}

	// Executed once after all test methods in the class.
	@AfterClass
	public static void tearDownClass() {
		System.out.println("One-time class cleanup login");
	}

	// Marks a test method to be ignored.
	@Ignore
	@Test
	public void ignoredTest() {
		System.out.println("This test will be ignored");
	}

//	@Test
	public void methodWithOneParaTest() {
		int actual = jUnit4_EgClassEg.methodWithOnePara(10);

		int expected = 11;
		Assert.assertEquals(expected, actual);

		int expectedFalse = 10;
		Assert.assertEquals(expectedFalse, actual);
	}

//	@Test
	public void methodWithOneTwoParaTest() {
		int actual = jUnit4_EgClassEg.methodWithOneTwoPara(10, 15);

		int expected = 25;
		Assert.assertEquals(expected, actual);

		int expectedFalse = 26;
		Assert.assertEquals(expectedFalse, actual);
	}

//	@Test
	public void methodWithXPara() {
		int actual = jUnit4_EgClassEg.methodWithXPara(10, 15);
		int actual2 = jUnit4_EgClassEg.methodWithXPara(10, 15, 20);

		int expected = 25;
		Assert.assertEquals(expected, actual);

		int expected2 = 45;
		Assert.assertEquals(expected2, actual2);

		int expectedFalse = 18;
		Assert.assertEquals(expectedFalse, actual);
	}
*/
}
