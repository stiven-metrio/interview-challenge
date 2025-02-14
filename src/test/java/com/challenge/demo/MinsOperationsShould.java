package com.challenge.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinsOperationsShould {

  @ParameterizedTest
  @MethodSource("validCombinations")
  void validScenarios(int[] nums, int k, int result) {
    int response = MinOperations.minOperations(nums, k);
    assertEquals(response, result);
  }

  @ParameterizedTest
  @MethodSource("validCombinations")
  void validScenariosImprovedMethod(int[] nums, int k, int result) {
    int response = MinOperations.minOperationsImproved(nums, k);
    assertEquals(response, result);
  }

  private static Stream<Arguments> validCombinations() {
    return Stream.of(
      Arguments.of(new int[]{2, 11, 10, 1, 3}, 10, 2),
      Arguments.of(new int[]{1, 1, 2, 4, 9}, 20, 4),
      Arguments.of(new int[]{999999999, 999999999, 999999999}, 1000000000, 2),
      Arguments.of(new int[]{42, 46}, 42, 0),
      Arguments.of(new int[]{42, 46}, 42, 0)
    );
  }
}