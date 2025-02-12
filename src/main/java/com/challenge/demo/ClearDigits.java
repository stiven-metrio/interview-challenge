package com.challenge.demo;

/**
 * Clear Digits: Class for removing digits and their preceding characters from a given string.
 * <p>
 * This class provides two implementations:
 * <ul>
 *   <li>{@link #clearDigits(String)} - Uses substring manipulation (less efficient).</li>
 *   <li>{@link #clearDigits2(String)} - Uses StringBuilder for optimized performance.</li>
 * </ul>
 */
public class ClearDigits {

  /**
   * Removes each digit from the given string along with the character immediately to its left.
   * <p>
   * This implementation uses string slicing (`substring`), which creates multiple new string instances,
   * making it less efficient for large inputs.
   * </p>
   *
   * @param s the input string
   * @return a new string with all digits and their left-side characters removed
   */
  public static String clearDigits(String s) {
    for (int i = 0; i < s.length(); i++) {
      var character = s.charAt(i);
      if (Character.isDigit(character)) {
        String x = s.substring(0, i - 1);
        if (i + 1 < s.length()) {
          x = x + s.substring(i + 1);
          i = i - 2;
        }
        s = x;
      }
    }
    return s;
  }

  /**
   * Optimized version of {@link #clearDigits(String)} using a {@link StringBuilder}.
   * <p>
   * This method removes each digit and its left-side character efficiently by modifying
   * a {@link StringBuilder} in-place, reducing memory overhead.
   * </p>
   *
   * @param s the input string
   * @return a new string with all digits and their left-side characters removed
   */
  public static String clearDigits2(String s) {
    StringBuilder result = new StringBuilder(s);
    int i = 0;
    while (i < result.length()) {
      if (Character.isDigit(result.charAt(i))) {
        int removeIndex = Math.max(0, i - 1);
        result.delete(removeIndex, i + 1);
        i = Math.max(0, removeIndex - 1);
      } else {
        i++;
      }
    }
    return result.toString();
  }
}
