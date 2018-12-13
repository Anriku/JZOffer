package jzoffer.chapter6;

/**
 * 统计一个数字在排序数组中出现的次数。
 * 例如输入排序数组{1, 2, 3, 3, 3, 3, 4, 5}和数字3，3出现4次，因此输出4.
 *
 */
class NumberOfKey {

	public static void main(String[] args) {
		int[] num = {1, 2, 3, 3, 3, 3, 4, 5};
		System.out.println(getNumberOfKey(num, 3));
	}

	public static int getNumberOfKey(int[] num, int k) {
		int first = getFirstKey(num, k, 0, num.length - 1);
		int end = getLastKey(num, k, 0, num.length - 1);
		if (first == -1 || end == -1) {
			return 0;
		}
		return end - first + 1;
	}

	public static int getFirstKey(int[] num, int k, int s, int e) {
		
		// 数组中没有k
		if (s > e) {
			return -1;
		}

		int m = (e + s) / 2;
		int mData = num[m];

		if (mData == k) {
			if (m > 0 && num[m - 1] == k) {
				e--;
			} else {
				return m;
			}
		} else if (mData > k) {
			e--;
		} else {
			s++;
		}

		return getFirstKey(num, k, s, e);
	}

	public static int getLastKey(int[] num, int k, int s, int e) {
		// 数组中没有k
		if (s > e) {
			return -1;
		}

		int m = (e + s) / 2;
		int mData = num[m];

		if (mData == k) {
			if (m < num.length - 1 && num[m + 1] == k) {
				s++;
			} else {
				return m;
			}
		} else if (mData > k) {
			e--;
		} else {
			s++;
		}

		return getLastKey(num, k, s, e);
	}

}