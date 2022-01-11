package codeWarsJava;

import org.json.simple.JSONObject;

import java.io.*;
import java.util.Arrays;


public class Utilities {

  public static void printParagraph(String[][] arr) {

    int paragraphWidth = 50;
    // Step one: Define a dictionary object with words. (Hash list and separate Dicationary class would be better)
    String dictionary = "once upon a time there was young boy he fought like lion and" +
        "roared one too then upon star for" +
        "wished the strength had could translate to win his families business";
    // Step two: flatten the array into a string without braces or extra commas/spaces.
    String flattened = "";
    for (String[] strings : arr) {
      flattened += Arrays.deepToString(strings).replace("[", "").replace("]", "").replace(",,", ",").replace("  ", " ");
    }

    //Step three: Check each word in the string to make sure it exists in the dictionary and isn't a misspelled word.
    // Normally you would fix the misspelled words. However that is a complex process which requires determining
    // the most closely spelled word. It would be easiest to just use a third party library. In this instance it would
    // be better to simply replace the words with _____ or just get rid of them entirely.

    // Last step: print out each line of string to be 100 characters long or less, and do not break words.
    System.out.print("\n\t");
    while (flattened != "") {
      if (flattened.length() < paragraphWidth) {
        System.out.println(flattened);
        flattened = "";
      } else {
        while (!flattened.substring(0, paragraphWidth).endsWith(" ")) {
          paragraphWidth--;
        }
        System.out.println(flattened.substring(0, paragraphWidth));
        flattened = flattened.substring(paragraphWidth);
        paragraphWidth = 50;
      }
    }
    System.out.println();
  }

  public static void saveJsonToFile() {
    JSONObject obj = new JSONObject();
    obj.put(1, "a");
    obj.put(2, "b");
    try {
      final FileWriter writer = new FileWriter("./myJsonFiles/readableJson.txt");
      writer.write(obj.toJSONString());
      writer.flush();
      writer.close();
      File file = new File("./myJsonFiles/readableJson.txt");
      final BufferedReader br = new BufferedReader(new FileReader(file));
      String st;
      while ((st = br.readLine()) != null) {
        System.out.println(st);
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void serializeAndSaveJson() {
    JSONObject obj = new JSONObject();
    obj.put(1, "a");
    obj.put(2, "b");
    try {
      final File file = new File("./myJsonFiles");
      final File[] files = file.listFiles();
      final FileOutputStream fs = new FileOutputStream(file + "/jsonFile" + (files.length + 1) + ".txt");
      final ObjectOutputStream os = new ObjectOutputStream(fs);
      os.writeObject(obj);
      final FileInputStream fileInputStream = new FileInputStream("./myJsonFiles/jsonFile" + (files.length + 1) + ".txt");
      final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
      final JSONObject myReadObject = (JSONObject) objectInputStream.readObject();
      System.out.println(myReadObject);
    } catch (IOException | ClassNotFoundException e) {
      System.out.println(e.getMessage());
    }
  }

}
