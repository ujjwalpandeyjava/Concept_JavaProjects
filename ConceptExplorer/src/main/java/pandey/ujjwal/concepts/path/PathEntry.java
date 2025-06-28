package pandey.ujjwal.concepts.path;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathEntry {

	public static void main(String[] args) {
		Path realPath = null;
		Path relativePath = Paths.get("");
		try {
			realPath = relativePath.toRealPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(realPath);
	}
}