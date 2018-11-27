package JZOffer.chapter4;

/**
 * 判断一个数组序列是不是二叉搜索树的后序遍历
 */
public class VerifySequenceOfBST {

    public static void main(String[] args) {
        int[] sequence = new int[]{7,4,6,5};
        System.out.println(verify(sequence, 0, sequence.length - 1));
    }


    public static boolean verify(int[] sequence, int s, int e) {

        int root = sequence[e];
        boolean left = true, right = true;
        int separate;
        // separate指向分界点
        for (separate = s; separate < e; separate++) {
            if (sequence[separate] > root) {
                break;
            }
        }

        // 判断后面的结果是否符合二叉搜索树，也就是都大于分界点
        for (int i = separate + 1; i < e; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }

        if (separate - 1 - s > 0) {
            left = verify(sequence, s, separate - 1);
        }
        if (e - 1 - separate > 0) {
            right = verify(sequence, separate, e - 1);
        }

        return left && right;

    }

}
