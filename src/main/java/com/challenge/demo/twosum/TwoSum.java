package com.challenge.demo.twosum;

/**
 * Given an array of integers numbers and an integer target, return indexes of the two numbers such that they add up to the target.
 * <p>
 * <ul>
 *  <li>You may assume that each input would have exactly one solution, and you may not use the same element twice.</li>
 *  <li>You can return the answer in any order.</li>
 * </ul>
 * <p>
 * <strong>Example Usage:</strong>
 * <pre>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * </pre>
 * <p>
 * The solution uses a brute-force approach with a nested loop to find the matching indices.
 */
public class TwoSum {

  /**
   * Finds two indices in the given array whose corresponding values add up to the specified target.
   *
   * @param nums   the array of integers to search
   * @param target the target sum to find
   * @return an array containing the two indices that add up to the target, or an empty array if no solution exists
   */
  public static int[] twoSum(int[] nums, int target) {
    if (nums.length < 2) {
      return new int[]{};
    }
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    return new int[]{};
  }
}
