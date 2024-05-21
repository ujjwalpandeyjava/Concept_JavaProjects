package pandey.ujjwal.javaConcepts.path;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathEntry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path realPath = null;
		Path relativePath = Paths.get("");
		try {
			realPath = relativePath.toRealPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(realPath);
	}

}
