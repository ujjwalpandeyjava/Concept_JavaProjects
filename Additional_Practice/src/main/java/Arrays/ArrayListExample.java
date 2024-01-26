package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ArrayListExample {

	public static void main(String args[]) {
		ArrayList<String> color = new ArrayList<String>();
		color.add("Red");
		color.add("Pink");
		color.add("Black");
		color.add("Purple");
		System.out.println("Initial: " + color);
		color.remove("Purple");
		System.out.println("Final: " + color);

		List<String> strList = new ArrayList<String>();
		strList.add("Ujjwal");
		strList.add("a Ujjwal");
		strList.add("Pandey");
		System.out.println(strList);

		strList.sort((str1, str2) -> {
			int ret = str1.compareTo(str2); // return ret;
			if (ret < 0)
				return -1;
			else if (ret > 0)
				return 1;
			return 0;
		});
		System.out.println("1 " + strList);

		strList.sort((str1, str2) -> {
			int ret = str2.compareTo(str1); // compare
			if (ret < 0)
				return -1;
			else if (ret > 0)
				return 1;
			return 0;
		});
		System.out.println("2" + strList);

		System.out.println(strList);
		Collections.sort(strList);
		System.out.println(strList);
	}
}
