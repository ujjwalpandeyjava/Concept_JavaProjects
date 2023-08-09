// String and similar classes
class StringRelated {

  public static void main(String[] args) {
    // 1. String
    System.out.println("""

                Normal-String Example""");
    String S1 = "Simple string";
    S1.concat(" change will not add"); // Value does'nt get changed as we haven't assigned it to the field
    System.out.println(S1);
    S1 = S1.concat(" new String object assigned to same location"); // Now value get updated
    System.out.println(S1);
    // 2. StringBuffer
    System.out.println("""

                        StringBuffer Example""");
    StringBuffer sb = new StringBuffer();
    sb.append("Hello ");
    sb.append("world ");
    sb.append("between  ", 2, 5);
    System.out.println(sb);
    sb.delete(6, 7);
    System.out.println(sb);
    sb.deleteCharAt(7);
    System.out.println(sb);

    // 3. StringBuilder
    // Create a StringBuilder object using StringBuilder() constructor
    System.out.println("""
          
          StringBuilder Example""");
    //  StringBuilder object using StringBuilder() constructor
    StringBuilder str0 = new StringBuilder();
    str0.append("AABBCC");
    System.out.println("String0: " + str0.toString());

    //  StringBuilder object using StringBuilder(CharSequence) constructor
    StringBuilder str1 = new StringBuilder("AABBCCDD");
    System.out.println("String1: " + str1.toString());
    System.out.println("String1 capacity: " + str1.capacity());

    // StringBuilder object using StringBuilder(capacity) constructor
    // If the number of characters increases from its current capacity, it increases the capacity by (oldCapacity*2)+2.
    StringBuilder str2 = new StringBuilder(3);
    str2.append("AAB");
    System.out.println(
      "String2: " + str2.toString() + " | Capacity: " + str2.capacity()
    );
    System.out.println(
      "String2: " +
      str2.append("FFGGhhiijjkkll") +
      " | Capacity: " +
      str2.capacity()
    );

    // StringBuilder object using StringBuilder(String) constructor
    StringBuilder str3 = new StringBuilder(str1.toString());
    System.out.println("String3: " + str3.toString());
  }
}
