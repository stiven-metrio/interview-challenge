package com.challenge.demo;

/**
 * Check if a number is palindrome
 */
public class PalindromeNumber {

  /**
   * Determines if a given number is a palindrome
   *
   * @param number the integer to check
   * @return {@code true} if the integer is a palindrome, {@code false} otherwise
   */
  public static boolean isPalindrome(int number) {
    String strNumber = String.valueOf(number);
    StringBuilder strNumberBuilder = new StringBuilder(strNumber);
    String strNumberInverted = strNumberBuilder.reverse().toString();
    return strNumberInverted.equals(strNumber);
  }
}
