package streamEg;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamEg {

	public static void main(String[] args) {
		String[] array = { "One", "Two", "Three", "Four", "Five" };

		List<String> listFromStream = Arrays.stream(array).collect(Collectors.toList());
		System.out.println("List from array: " + listFromStream);

		Map<Object, Object> mapFromArray = Arrays.stream(array)
				.collect(Collectors.toMap(Arrays::asList, i -> i, (a, b) -> b));
		System.out.println("Map from array: " + mapFromArray);
	}

}
