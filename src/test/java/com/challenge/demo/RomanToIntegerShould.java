package com.challenge.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanToIntegerShould {

  @ParameterizedTest
  @MethodSource("romanNumbers")
  void romanToIntValid(String s, int expected) {
    int result = RomanToInteger.romanToInt(s);
    assertEquals(expected, result);
  }

  private static Stream<Arguments> romanNumbers() {
    return Stream.of(
      Arguments.of("III", 3),
      Arguments.of("LVIII", 58),
      Arguments.of("MCMXCIV", 1994)
    );
  }
}
