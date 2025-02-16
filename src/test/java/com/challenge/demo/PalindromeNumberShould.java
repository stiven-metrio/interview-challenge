package com.challenge.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromeNumberShould {

  @ParameterizedTest
  @MethodSource("testValues")
  void checkIfNumbersArePalindrome(int number, boolean expected) {
    boolean isPalindrome = PalindromeNumber.isPalindrome(number);
    assertEquals(isPalindrome, expected);
  }

  private static Stream<Arguments> testValues() {
    return Stream.of(
      Arguments.of(121, true),
      Arguments.of(-121, false),
      Arguments.of(10, false)
    );
  }
}
