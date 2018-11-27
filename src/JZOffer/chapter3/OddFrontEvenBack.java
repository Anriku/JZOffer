package JZOffer.chapter3;

/**
 * 奇数在前偶数在后
 */
public class OddFrontEvenBack {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        adjustArray(array, new Strategy() {
            @Override
            public boolean isFontSatisfied(int i) {
                return (i & 0x1) != 0;
            }

            @Override
            public boolean isBackSatisfied(int i) {
                return (i & 0x1) == 0;
            }
        });
        for (int i: array) {
            System.out.println(i);
        }
    }

    public static void adjustArray(int[] array, Strategy strategy) {
        int font = 0, back = array.length - 1;

        while (font < back) {
            while (font < back && strategy.isFontSatisfied(array[font])) {
                font++;
            }

            while (font < back && strategy.isBackSatisfied(array[back])) {
                back--;
            }

            if (font < back) {
                int temp = array[font];
                array[font] = array[back];
                array[back] = temp;
            }
        }
    }

    interface Strategy {
        public boolean isFontSatisfied(int i);

        public boolean isBackSatisfied(int i);
    }
}
