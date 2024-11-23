package pandey.ujjwal.javaConcepts.fileReader;

import java.io.*;

class FileHandlling {
	public static void main(String as[]) throws IOException {

		FileReader fr = null;
		try {
			fr = new FileReader("./codeUploads/Text.txt");
		} catch (IOException e) {
			System.out.println("File not found.");
		}
		
		int ch;
		var strBuffer = new StringBuffer(); 
		while ((ch = fr.read()) != -1)
			strBuffer.append(Character.toString(ch));

		System.out.println(strBuffer.toString());
	}
}