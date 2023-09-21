package train.tasks.leetcode;

import java.util.Scanner;

public class Findtarget {

    public static void main(String[] args) {

        TwoSumSolution solution = new TwoSumSolution();

        Scanner sc = new Scanner(System.in);
        int[] numbers = {2, 7, 11, 15};
        System.out.println("Input target: ");
        int target = sc.nextInt();

        int[] result = solution.twoSum(numbers, target);

        if (result != null) {
            for (int var : result) {
                System.out.print(var + " ");
            }
        } else {
            System.out.println("No solution found.");
        }

        sc.close();
    }
}

class TwoSumSolution {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i <= nums.length - 2; i++) {
            int currentNumber = nums[i];
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if (currentNumber + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}