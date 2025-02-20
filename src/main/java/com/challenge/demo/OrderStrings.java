package com.challenge.demo;

import java.util.Arrays;

/**
 * This class provides a method to order alphabetic substrings within a mixed alphanumeric string.
 */
public class OrderStrings {

  /**
   * Orders all alphabetic substrings within a given string while keeping digits in place.
   *
   * @param str The input string containing letters and digits.
   * @return The modified string with alphabetic substrings sorted in ascending order.
   */
  public static String orderStrings(String str) {
    boolean isStart = true;
    int indexStart = 0, indexEnd;
    for (int i = 0; i < str.length(); i++) {
      var isDigit = Character.isDigit(str.charAt(i));
      if (!isDigit && isStart) {
        indexStart = i;
        isStart = false;
      } else if (isDigit && !isStart || i == str.length() - 1) {
        indexEnd = i == str.length() - 1 && !isDigit ? i + 1 : i;
        String[] substring = orderSubstring(str, new int[]{indexStart, indexEnd});
        str = str.replaceAll(substring[0], substring[1]);
        isStart = true;
      }
    }
    return str;
  }

  /**
   * Extracts a substring within the given range, sorts its characters, and returns both original and sorted versions.
   *
   * @param str   The input string.
   * @param range An integer array where range[0] is the start index and range[1] is the end index.
   * @return A string array containing the original substring and its sorted version.
   */
  private static String[] orderSubstring(String str, int[] range) {
    String toOrder = str.substring(range[0], range[1]);
    char[] chars = toOrder.toCharArray();
    Arrays.sort(chars);
    String sorted = new String(chars);
    return new String[]{toOrder, sorted};
  }
}
