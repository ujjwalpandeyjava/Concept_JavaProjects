package seperate;

//import java.io.Exception.*;
import java.io.*;

class FileHandlling {
	public static void main(String as[]) throws IOException {
		int ch;

		FileReader fr = null;
		try {
			fr = new FileReader("Text.txt");
		} catch (IOException e) {
			System.out.println("File not found.");
		}
		while ((ch = fr.read()) != -1) {
			System.out.print((char) ch);
		}
	}
}