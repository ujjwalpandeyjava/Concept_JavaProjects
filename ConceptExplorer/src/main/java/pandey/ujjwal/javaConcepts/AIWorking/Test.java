package pandey.ujjwal.javaConcepts.AIWorking;

public class Test {

	public static void main(String[] args) {

		String string = "Banana";
		String pattern = "nnn";
//		String[] split = string.split(pattern);
		System.out.println(findSubString(string, pattern));
	}
	
	
	/*
	 	Input string = “aabccaadcbaabc”,
		Pattern = “aa”
		Output: 3
		
		Input string = “Banana”,
		pattern = “nnn”
		Output: 0
		Input string = “aaaaa”
		pattern = “aa”, 
		Output : 4
	 */
	private static String findSubString(String string, String pattern) {
		int windowSize = pattern.length();
		int sLen = string.length();
		int count = 0;
		System.out.println("String: " + string);
		System.out.println("Pattern: " + pattern);
		
		for (int i = 0; i < sLen; i++) {
			if(i+ windowSize <= sLen) {
				String ele = string.substring(i, (i +windowSize));
				if(ele.equals(pattern))count++;
			}
		}
		System.out.println(count);
		
		return "";
	}

}
