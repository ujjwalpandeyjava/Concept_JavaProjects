package fileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class FileReaderWordCount {

  public static void main(String[] args) throws IOException {
    File f1 = new File("input.txt"); //Creation of File Descriptor for input file
    //It is located on the same path of the .java file
    String[] words = null;
    int wc = 0;
    FileReader fr = new FileReader(f1);
    BufferedReader br = new BufferedReader(fr);
    String s;
    while ((s = br.readLine()) != null) { //Reading Content from the file
      words = s.split(" "); //Split the word using space
      wc = wc + words.length; //increase the word count for each word
    }
    fr.close();
    System.out.println("Number of words in the file:" + wc);
  }
}
