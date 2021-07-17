package codeWarsJava;

//The goal of this kata is to design a method that can take a integer (seconds) and turn it into HH:MM:SS format
// the input integer will never exceed 359999 = 99:59:59
public class HumanReadableTime {
  public static String makeReadable(int seconds) {
    int hh, mm, ss = 0;
    hh = seconds / 60 / 60;
    mm = seconds / 60 % 60;
    ss = seconds % 60 % 60;
    System.out.printf("%02d:%02d:%02d %n", hh, mm, ss);
    return String.format("%02d:%02d:%02d", hh, mm, ss);
  }
}
