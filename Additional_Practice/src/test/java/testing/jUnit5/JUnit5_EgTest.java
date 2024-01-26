package testing.jUnit5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testing.jUnit4.JUnit4_Eg;

public class JUnit5_EgTest {
	JUnit4_Eg jUnit4_EgClassEg = new JUnit4_Eg();

	// Assertion Methods:
	static {
		System.out.println("Inside static");
		// Asserts that two values are equal.
		Assertions.assertEquals("", "");

		// Asserts that a condition is true.
		Assertions.assertTrue(isReturnTrue());

		// Asserts that a condition is false.
		Assertions.assertFalse(!isReturnTrue());

		// Asserts that an object is not null.
		Assertions.assertNotNull(isReturnTrue());

		// Asserts that an object is null.
//		Assertions.assertNull(isReturnTrue());
		Assertions.assertNull(null);

		// Asserts that two arrays are equal.
		int[] actualArray = {};
		int expectedArray[] = {};
		int expectedArray1[] = { 1, 2 };
		Assertions.assertArrayEquals(expectedArray, actualArray);
//		Assertions.assertArrayEquals(expectedArray1, actualArray); // Failing this will not let the methods work...
	}

	private static boolean isReturnTrue() {
		return true;
	}

	@TestFactory
//	 Marks a method as a test method.
	@Test
	@DisplayName("Custom names")	// supposed to show methodName
	public void simpleMethodTest() {
		// Test logic here
		System.out.println("@Test");
		jUnit4_EgClassEg.simpleMethod();
	}

//	Before each test method.
	@BeforeEach
	public void setUp() {
		System.out.println("Initialization logic before each test");
	}

//	After each test method.
	@AfterEach
	public void tearDown() {
		System.out.println("Cleanup logic after each test");
	}

	// Executed once before any test methods in the class.
	@BeforeAll
	public static void setUpClass() {
		System.out.println("One-time class based initialization logic");
	}

	// Executed once after all test methods in the class.
	@AfterAll
	public static void tearDownClass() {
		System.out.println("One-time class cleanup login");
	}

	// Marks a test method to be ignored.
	@Disabled
	@Test
	public void ignoredTest() {
		System.out.println("This test will be ignored");
	}

//	@Test
	public void methodWithOneParaTest() {
		int actual = jUnit4_EgClassEg.methodWithOnePara(10);

		int expected = 11;
		Assertions.assertEquals(expected, actual);

		int expectedFalse = 10;
		Assertions.assertEquals(expectedFalse, actual);
	}

//	@Test
	public void methodWithOneTwoParaTest() {
		int actual = jUnit4_EgClassEg.methodWithOneTwoPara(10, 15);

		int expected = 25;
		Assertions.assertEquals(expected, actual);

		int expectedFalse = 26;
		Assertions.assertEquals(expectedFalse, actual);
	}

//	@Test
	public void methodWithXPara() {
		int actual = jUnit4_EgClassEg.methodWithXPara(10, 15);
		int actual2 = jUnit4_EgClassEg.methodWithXPara(10, 15, 20);

		int expected = 25;
		Assertions.assertEquals(expected, actual);

		int expected2 = 45;
		Assertions.assertEquals(expected2, actual2);

		int expectedFalse = 18;
		Assertions.assertEquals(expectedFalse, actual);
	}

}
