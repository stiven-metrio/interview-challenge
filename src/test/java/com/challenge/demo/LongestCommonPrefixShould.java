package com.challenge.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestCommonPrefixShould {

  @ParameterizedTest
  @MethodSource("getStringsArray")
  void validatePrefix(String[] strs, String expected) {
    String result = LongestCommonPrefix.longestCommonPrefix(strs);
    assertEquals(expected, result);
  }

  private static Stream<Arguments> getStringsArray() {
    return Stream.of(
      Arguments.of(new String[]{"flower", "flow", "flight"}, "fl"),
      Arguments.of(new String[]{"dog", "racecar", "car"}, ""),
      Arguments.of(new String[]{"ab", "a"}, "a")
    );
  }
}
