package com.challenge.demo;

/**
 * FInd the longest prefix among an array of Strings
 */
public class LongestCommonPrefix {

  /**
   * Find the longest prefix among an array of Strings
   *
   * @param strs the array of Strings
   * @return the longest common prefix in the array of Strings
   */
  public static String longestCommonPrefix(String[] strs) {
    StringBuilder result = new StringBuilder();
    if (strs.length > 0) {
      String firstWord = strs[0];
      for (int i = 0; i < firstWord.length(); i++) { // Character loop
        for (int j = 1; j < strs.length; j++) { // words loop
          if (strs[j].length() < i + 1 || strs[j].charAt(i) != firstWord.charAt(i)) {
            return result.toString();
          }
        }
        result.append(firstWord.charAt(i));
      }
    }
    return result.toString();
  }
}
