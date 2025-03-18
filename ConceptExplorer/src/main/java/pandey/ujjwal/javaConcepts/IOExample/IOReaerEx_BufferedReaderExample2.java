package pandey.ujjwal.javaConcepts.IOExample;

import java.io.IOException;

public class IOReaerEx_BufferedReaderExample2 {
	// Must check exceptions
	public static void main(String[] args) throws IOException {
		/* Theory
		 * https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
		 * Buffered meaning: It mean the content is not read at once, the content is read and temporarily stored in the specified size of the BufferedReader object (default is 8kb) 
		*/
		
/*------------------------------------------------------------------------------------------------------------------------------*/
		/* Normal Input from console */
		// Way 1
		/*String s1 = "";
		int x = 0;
		BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter a number: ");
		s1 = brr.readLine();
		System.out.println("String form: " +s1);
		x = Integer.parseInt(s1);
		System.out.println("Integer form: " +x);

		System.out.print("Enter second number to take input with shorthand: ");
		int y = Integer.parseInt(brr.readLine());
		System.out.println("The second integer input: " +y);
		*/
		
		
/*------------------------------------------------------------------------------------------------------------------------------*/
		/*File input*/
		// Options we use them without knowing
		/* 1). FileReader(File object)		// need BufferedReader
		 * 2). FileReader(FileDescriptor object)	//
		 * 3). FileReader(String object)	//no need of BufferedReader
		 */
		/*String filePath = "ReadFromHear.txt";

		// Way 1: Using BufferedReader
		File file = new File(filePath); 
		BufferedReader br1 = new BufferedReader(new FileReader(filePath));	//With file path -- Line by line
		BufferedReader br2 = new BufferedReader(new FileReader(filePath));	//With file path -- char by char
		BufferedReader br3 = new BufferedReader(new FileReader(file));		//With file object --line by line
		BufferedReader br4 = new BufferedReader(new FileReader(file));		//With file object --char by char
		
		// One way of reading the file
		System.out.println("Reading the file using readLine() method: (line-by-line)");
		String contentLine = "";
		while ((contentLine = br1.readLine()) != null) 
			System.out.println(contentLine);

		// Second way of reading the file
		System.out.println("Reading the file using read() method: (char-by-char)");
		int num = 0;
		while ((num = br2.read()) != -1)	//-1 is EOF
			System.out.print((char) num);
		
		//Third way of reading the file
		System.out.println("Reading the file using readLine() method: (line-by-line)");
		String st;
		  while ((st = br3.readLine()) != null)
		    System.out.println(st);

		//Forth way of reading the file
		System.out.println("Reading the file using read() method: (char-by-char)");
		int num2 = 0;
		while((num2 = br4.read())!=-1)
			System.out.print((char) num2);
		
		
		br1.close();
		br2.close();
		br3.close();
		br4.close();
		
		
		
		// Way 2: Using FileReader class only (Same with scanner pass File object instead of System.in)
		//It does not buffer, it loads one line at a time (not good)
		System.out.println("Reading the file using FileReader's read() method: (line-by-line)");
		int num3 = 0;
		FileReader fr = new FileReader(filePath); // Option 3:- Reads char by char
		while ((num3 = fr.read()) != -1)
			System.out.print((char) num3);
		
		fr.close();

		//There are 4 more ways but they are very very bad
		*/
	}

}
