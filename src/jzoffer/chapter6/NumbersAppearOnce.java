package jzoffer.chapter6;

/**
 * 一个整型数组里除了两个数字之外，其它数字都出现了两次。请找出这两个只出现一次的数字。要求时间复杂度为O(n)，空间复杂度为O(1)
 */
class NumbersAppearOnce {

	public static void main(String[] args) {
		Num first = new Num();
		Num second = new Num();
		int[] num = {2, 4, 3, 6, 3, 2, 5, 5};


		findNumbersAppearOnce(num, first, second);
		System.out.println(first.value);
		System.out.println(second.value);
	}

	public static void findNumbersAppearOnce(int[] num, Num first, Num second) {
		int bitResult = 0;
		int xorNum = 0;
		for (int i = 0; i < num.length; i++) {
			xorNum ^= num[i];
		}

		bitResult = findTheFirstOneBit(xorNum);

		for (int i = 0; i < num.length; i++) {
			if (isBit1(num[i], bitResult)) {
				first.value ^= num[i];
			} else {
				second.value ^= num[i];
			}
		}
	}

	public static int findTheFirstOneBit(int xorNum) {
		int result = 1;
		while ((xorNum & result) == 0 && result != 0) {
			result = result << 1;
		}
		return result;
	}


	public static boolean isBit1(int num, int bitResult) {
		return (num & bitResult) == 0 ? false : true;
	}



	static class Num {
		int value;
	}

}