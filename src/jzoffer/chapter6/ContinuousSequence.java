package jzoffer.chapter6;

/**
 * 输入一个正数s，打印出所有和为s的连续序列。
 * 如：输入9。则输出{2, 3, 4},{4, 5}
 */
class ContinuousSequence {

	public static void main(String[] args) {
		findContinuousSequence(9);
	}

	public static  void findContinuousSequence(int sum) {
		int middle = (1 + sum) / 2;
		int small = 1;
		int big = 2;
		int result = small + big;

		while (small < middle) {
			if (result == sum) {
				printResult(small, big);
			}

			while (result > sum && small < middle) {
				result -= small;
				small++;
				if (result == sum) {
					printResult(small, big);
				}
			}
			big++;
			result += big;
		}
	}


	public static void printResult(int small, int big) {
		for (int i = small; i <= big; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}