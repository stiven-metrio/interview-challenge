package com.challenge.demo.twosum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoSumShould {

  @ParameterizedTest
  @MethodSource("targetNumbers")
  void allValidScenarios(int[] nums, int target, int i, int j) {
    int[] result = TwoSum.twoSum(nums, target);

    assertEquals(result[0], i);
    assertEquals(result[1], j);
  }

  private static Stream<Arguments> targetNumbers() {
    return Stream.of(
      Arguments.of(new int[]{2, 7, 11, 15}, 9, 0, 1),
      Arguments.of(new int[]{3, 2, 4}, 6, 1, 2),
      Arguments.of(new int[]{3, 3}, 6, 0, 1)
    );
  }

  @ParameterizedTest
  @MethodSource("invalidCombinations")
  void twoSmallArray(int[] nums, int target) {
    int[] result = TwoSum.twoSum(nums, target);

    assertEquals(result.length, 0);
  }

  private static Stream<Arguments> invalidCombinations() {
    return Stream.of(
      Arguments.of(new int[]{}, 6),
      Arguments.of(new int[]{1}, 1),
      Arguments.of(new int[]{1, 3}, 5)
    );
  }
}
