package chapter2;

/**
 * 求旋转数组中的最小数
 */
public class RotateArray {

    public static void main(String[] args) {
        System.out.println(min(new int[]{0, 1, 1, 1, 1}, 5));
    }

    public static int min(int nums[], int length) {
        int index1 = 0, index2 = length - 1, midIndex = index1;

        while (nums[index1] >= nums[index2]) {
            if (index2 - index1 == 1) {
                midIndex = index2;
                break;
            }

            midIndex = (index1 + index2) / 2;

            if (nums[index1] == nums[index2] &&
                    nums[midIndex] == nums[index1]) {
                return minInOrder(nums, index1, index2);
            }

            if (nums[index1] <= nums[midIndex]) {
                index1 = midIndex;
            } else if (nums[index1] >= nums[midIndex]) {
                index2 = midIndex;
            }
        }
        return midIndex;
    }


    public static int minInOrder(int nums[], int index1, int index2) {
        int min = index1;
        for (int i = index1 + 1; i < index2; i++) {
            if (nums[min] > nums[i]) {
                min = i;
            }
        }
        return min;
    }
}
