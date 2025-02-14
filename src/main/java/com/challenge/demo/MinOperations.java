package com.challenge.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 * This class provides methods to determine the minimum number of operations required
 * to ensure all elements in an array meet a given threshold.
 */
public class MinOperations {

  /**
   * Computes the minimum number of operations required to make all elements in the array
   * greater than or equal to the given threshold.
   * <p>
   * An operation consists of removing the two smallest elements, applying a formula,
   * and adding the result back to the list.
   *
   * @param nums an array of integers
   * @param k    the threshold value
   * @return the minimum number of operations, or -1 if not possible
   */
  public static int minOperations(int[] nums, int k) {
    var numsList = Arrays.stream(nums)
      .mapToLong(num -> num)
      .boxed()
      .collect(Collectors.toCollection(ArrayList::new));
    if (numsList.size() >= 2) {
      int count = 0;
      while (true) {
        if (validateIfAllNumsGreaterThanK(numsList, k)) {
          return count;
        }
        // Get two mins and remove them from nums
        Long minOne = numsList.stream().min(Long::compareTo).get();
        numsList.remove(minOne);
        Long minTwo = numsList.stream().min(Long::compareTo).get();
        numsList.remove(minTwo);
        List<Long> mins = List.of(minOne, minTwo);

        // Add new value
        Long partOne = (mins.stream().min(Long::compareTo).get()) * 2;
        Long partTwo = mins.stream().max(Long::compareTo).get();
        Long newVal = Long.sum(partOne, partTwo);
        numsList.add(newVal);
        count++;
      }
    }
    return -1;
  }

  /**
   * Checks if all elements in the list are greater than or equal to the threshold.
   *
   * @param numsList the list of numbers to check
   * @param k        the threshold value
   * @return true if all elements are greater than or equal to k, false otherwise
   */
  private static boolean validateIfAllNumsGreaterThanK(ArrayList<Long> numsList, int k) {
    AtomicBoolean goal = new AtomicBoolean(true);
    numsList.forEach(num -> {
      if (num < k)
        goal.set(false);
    });
    return goal.get();
  }

  /**
   * An optimized version of minOperations using a priority queue (min-heap) to efficiently
   * retrieve and process the smallest elements.
   *
   * @param nums an array of integers
   * @param k    the threshold value
   * @return the minimum number of operations required
   */
  public static int minOperationsImproved(int[] nums, int k) {
    PriorityQueue<Long> minHeap = new PriorityQueue<Long>(
      Arrays.stream(nums)
        .mapToLong(i -> (long) i)
        .boxed()
        .collect(Collectors.toList())
    );
    int numOperations = 0;

    while (minHeap.peek() < k) {
      long x = minHeap.remove();
      long y = minHeap.remove();
      minHeap.add(Math.min(x, y) * 2 + Math.max(x, y));

      numOperations++;
    }
    return numOperations;
  }
}
